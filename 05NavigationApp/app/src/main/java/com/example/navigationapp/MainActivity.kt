package com.example.navigationapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null){
            supportFragmentManager.beginTransaction().replace(R.id.fragment_home_xml,HomeFragment()).commit()
//            subistituindo conteiner pelo fragment
//            no slide tava meio vago como se conectavam

        }

    }
}