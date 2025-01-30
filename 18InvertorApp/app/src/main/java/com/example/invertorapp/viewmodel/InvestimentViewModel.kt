package com.example.invertorapp.viewmodel


import android.Manifest
import android.annotation.SuppressLint
import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.lifecycle.AndroidViewModel
import com.example.invertorapp.MainActivity
import com.example.invertorapp.R
import com.example.invertorapp.model.Investiment
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class InvestimentoViewModel(application: Application) : AndroidViewModel(application) {

    private val database = FirebaseDatabase.getInstance()
        .reference.child("investimentos")

    private val _investimento = MutableStateFlow<List<Investiment>>(emptyList())
    val investimento: StateFlow<List<Investiment>> = _investimento

    init {
        monitorarAlteracoe()
    }

    private fun monitorarAlteracoe(){
        database.addChildEventListener(object : ChildEventListener {
            override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {
                val name = snapshot.child("name").getValue(String::class.java) ?: "Unknow"
                val value = snapshot.child("value").getValue(Int::class.java) ?: 0

                sendNotification("Actual Investiment","$name - USD$$value")
                loadInvestiments()
            }

            override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                loadInvestiments()
            }

            override fun onChildRemoved(snapshot: DataSnapshot) {
                loadInvestiments()
            }

            override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("FirebaseError", "Alteracao nao mapeada: ${error.message}")
            }
        })
    }

    fun loadInvestiments(){
        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val list = mutableListOf<Investiment>()

                for (item in snapshot.children){
                    val name = item.child("name").getValue(String::class.java) ?: "Unknow"

                    val value = item.child("value").getValue(Int::class.java) ?: 0

                    list.add(Investiment(name,value))
                }

                _investimento.value = list
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("FirebaseError", "Error in loadInvestiments: ${error.message}")
            }
        })
    }

    @SuppressLint("MissingPermission")
    private fun sendNotification(titulo: String, mensagem: String) {

        val channelId = "investimentos_notifications"
        val notificationId = (System.currentTimeMillis() % 10000).toInt()

        // Criar um canal de notificação (necessário para Android 8.0+)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                channelId,
                "Notificações de Investimentos",
                NotificationManager.IMPORTANCE_HIGH
            )
            val notificationManager =
                getApplication<Application>().getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }

        // Intent para abrir a MainActivity ao clicar na notificação
        val intent = Intent(getApplication(), MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent = PendingIntent.getActivity(
            getApplication(),
            0,
            intent,
            PendingIntent.FLAG_ONE_SHOT or PendingIntent.FLAG_IMMUTABLE
        )

        // Criar e exibir a notificação
        val notification = NotificationCompat.Builder(getApplication(), channelId)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle(titulo)
            .setContentText(mensagem)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .build()

        NotificationManagerCompat.from(getApplication()).notify(notificationId, notification)
    }
}