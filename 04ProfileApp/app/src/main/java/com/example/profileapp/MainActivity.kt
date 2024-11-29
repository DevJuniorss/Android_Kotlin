package com.example.profileapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

//      Initializing Components
//        Profile
        val introLayout = findViewById<LinearLayout>(R.id.MyPerfilLayout)
        val profileImage = findViewById<ImageView>(R.id.ProfilePhotoIv)
        val nameText =  findViewById<TextView>(R.id.NameTv)
        val descriptionText = findViewById<TextView>(R.id.DescriptioTv)
        val actualJobText = findViewById<TextView>(R.id.ActualJobTv)
        val phoneNumberText = findViewById<TextView>(R.id.PhoneNumberTv)
        val emailText = findViewById<TextView>(R.id.EmailTv)
        val adressText = findViewById<TextView>(R.id.AdressTv)

//        Job's Exp
        val jobExperiencesLayout = findViewById<LinearLayout>(R.id.JobExpLayout)

//        In case that I would  write one by one
//        val firstJobText = findViewById<TextView>(R.id.FirstJobTv)
//        val secondJobText = findViewById<TextView>(R.id.SecondJobTv)
//        val thirdJobText = findViewById<TextView>(R.id.ThirdJobTv)
//        val futureGoalsText =  findViewById<TextView>(R.id.FutureGoalsTv)

//      Setting profile infos
//       real informations
        nameText.text = "Alexandre Junior"
        descriptionText.text = "FullStack Dev Java, Brazillian 28 years old "
        actualJobText.text = "Free-lancer and Student at UFC"
        phoneNumberText.text = "+55(XX)XXXXX-XXXX"
//      real e-mail
        emailText.text = "lazysdeveloper@gmail.com"
        adressText.text = "Sitio Amanaju, Senador Pompeu - CE"

//       Exp List
        val experiences = listOf(
            "Agricultor no Assentamento Amanju de 2000 a 2015",
            "Tecnico em Comercio na Empresa Dbase Informatica de junho a dezembro de 2013",
            "Analista de Dados e Sistemas na Prefeitura Municipal de Senador Pompeu  de janeiro de 2021 a marco de 2023",
            "Concluir duas pos na area de IA e se possivel me inscrever em um doutorado.")

//      Add Exp dinamic
        for (experience in experiences){
            val textView = TextView(this)
            textView.text =experience
            textView.textSize = 10f
            jobExperiencesLayout.addView(textView)
        }

//      info about my photo
        profileImage.setOnClickListener {
            Toast.makeText(this,"Foto de Alexandre Junior no Campus de Quixada", Toast.LENGTH_SHORT).show()
        }
    }
}