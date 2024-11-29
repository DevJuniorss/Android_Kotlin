package com.example.lifecycleapp

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //Log and Toast message of OnCreate

        Log.d("LifeCycleApp","OnCreate Called")
        Toast.makeText(this,"OnCreate called", Toast.LENGTH_LONG).show()
    }

    override fun onStart() {
        super.onStart()

        //Log and Toast message of OnStart

        Log.d("LifeCycleApp","OnStart Called")
        Toast.makeText(this,"OnStart called", Toast.LENGTH_LONG).show()
    }

    override fun onPause() {
        super.onPause()

        //Log and Toast message of OnPause

        Log.d("LifeCycleApp","OnPause Called")
        Toast.makeText(this,"OnPause called", Toast.LENGTH_LONG).show()
    }

    override fun onResume() {
        super.onResume()

        //Log and Toast message of OnResume

        Log.d("LifeCycleApp","OnResume Called")
        Toast.makeText(this,"OnResume called", Toast.LENGTH_LONG).show()
    }

    override fun onStop() {
        super.onStop()

        //Log and Toast message of OnStop

        Log.d("LifeCycleApp","OnStop Called")
        Toast.makeText(this,"OnStop called", Toast.LENGTH_LONG).show()
    }

    override fun onRestart() {
        super.onRestart()

        //Log and Toast message of OnRestart

        Log.d("LifeCycleApp","OnRestart Called")
        Toast.makeText(this,"OnRestart called", Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()

        //Log and Toast message of OnDestroy

        Log.d("LifeCycleApp","OnDestroy Called")
        Toast.makeText(this,"OnDestroy called", Toast.LENGTH_LONG).show()
    }

}