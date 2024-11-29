package com.example.threedotsmenu

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
    }
//  Metodo que infla estrutura na tela
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }
//  Metodo que lida com cliques
//  Estrutura de loop (estudar mais arrow functions)
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.action_Settings ->{
                Toast.makeText(this, "Configurations Selected",Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_Help ->{
                Toast.makeText(this,"Help Requested!", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_About ->{
                Toast.makeText(this,"About Selected",Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}