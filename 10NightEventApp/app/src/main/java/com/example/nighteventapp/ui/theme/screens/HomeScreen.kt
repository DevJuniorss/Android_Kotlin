package com.example.nighteventapp.ui.theme.screens

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.nighteventapp.models.events
import android.Manifest
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat

@Composable
fun HomeScreen(navController: NavHostController, context: Context) {
    createNotificationChannel(context)

    Column {
        val subEvents = events.filter { it.isSubscribed.value }

        // Seção de eventos inscritos
        if (subEvents.isNotEmpty()) {
            Text(
                text = "Eventos Inscritos",
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier.padding(20.dp)
            )
            LazyRow(
                modifier = Modifier.padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(subEvents.size) { index ->
                    val event = subEvents[index]
                    Card(
                        modifier = Modifier
                            .size(100.dp)
                            .clickable { navController.navigate("eventDetails/${event.id}") },
                        elevation = CardDefaults.cardElevation(4.dp)
                    ) {
                        Image(
                            painter = painterResource(id = event.imageRes),
                            contentDescription = event.title,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Listagem geral de eventos
        LazyColumn(
            modifier = Modifier.padding(16.dp)
        ) {
            items(events.size) { index ->
                val event = events[index]
                Card(
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                        .clickable { navController.navigate("eventDetails/${event.id}") },
                    elevation = CardDefaults.cardElevation(6.dp)
                ) {
                    Column(modifier = Modifier.fillMaxWidth().padding(20.dp)) {
                        Row(modifier = Modifier.fillMaxWidth()) {
                            Image(
                                painter = painterResource(id = event.imageRes),
                                contentDescription = event.title,
                                modifier = Modifier
                                    .size(64.dp)
                                    .clip(CircleShape),
                                contentScale = ContentScale.Crop
                            )
                            Spacer(modifier = Modifier.width(20.dp))
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = event.title,
                                    style = MaterialTheme.typography.titleMedium
                                )
                                Text(
                                    text = event.location,
                                    style = MaterialTheme.typography.bodySmall,
                                    modifier = Modifier.padding(top = 4.dp)
                                )
                            }
                            Icon(
                                imageVector = if (event.isFavorite.value) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                                contentDescription = "Favorite",
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier
                                    .size(24.dp)
                                    .clickable { event.isFavorite.value = !event.isFavorite.value }
                            )
                        }

                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = event.description,
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Button(
                            onClick = {
                                event.isSubscribed.value = !event.isSubscribed.value
                                if (event.isSubscribed.value) {
                                    sendNotification(context, event.title)
                                }
                            },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = if (event.isSubscribed.value) "Inscrito" else "Se Inscrever"
                            )
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        Button(
                            onClick = { navController.navigate("eventDetails/${event.id}") },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(text = "Ver mais sobre ${event.title}")
                        }
                    }
                }
            }
        }
    }
}

private fun createNotificationChannel(context: Context) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val channelName = "Inscrição de Eventos"
        val description = "Canal para notificações de inscrição em eventos"
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val channel = NotificationChannel("EVENT_CHANNEL", channelName, importance).apply {
            this.description = description
        }
        val notificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }
}

private fun sendNotification(context: Context, eventTitle: String) {
    try {
        // Verificar se a permissão foi concedida
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            val hasPermission = ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.POST_NOTIFICATIONS
            ) == PackageManager.PERMISSION_GRANTED
            if (!hasPermission) {
                return
            }
        }

        val builder = NotificationCompat.Builder(context, "EVENT_CHANNEL")
            .setSmallIcon(android.R.drawable.ic_notification_overlay)
            .setContentTitle("Inscrição Confirmada")
            .setContentText("Você foi inscrito no evento: $eventTitle")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        with(NotificationManagerCompat.from(context)) {
            notify(eventTitle.hashCode(), builder.build())
        }

    } catch (e: SecurityException) {
        e.printStackTrace()
    }
}
