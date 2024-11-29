package com.example.layoutapp

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet

//Exemplo
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//      ContraintLayout como Layout primario

//      val variavel imutavel ideal para definir algo como uma constraintLayout

        val layout = ConstraintLayout(this).apply {
            layoutParams =  ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT)
        }

//      Creating title TextView

        val titleTextView = TextView(this).apply {
            id = View.generateViewId()
            text = "Welcome"
            textSize = 24f
        }

//      Creating EditText for input

        val inputEditText = EditText(this).apply{
            id = View.generateViewId()
            hint = "Say Something"
        }

//      Creating Button

        val actionButton = Button(this).apply {
            id = View.generateViewId()
            text = "Clic Here!"
        }

//      Adding layout views

        layout.addView(titleTextView)
        layout.addView(inputEditText)
        layout.addView(actionButton)

//      Defining ConstraintLayout

        val set = ConstraintSet()
        set.clone(layout)

//      Title Constraints

        set.connect(titleTextView.id, ConstraintSet.TOP, layout.id, ConstraintSet.TOP, 32)
        set.connect(titleTextView.id, ConstraintSet.START, layout.id, ConstraintSet.START, 32)
        set.connect(titleTextView.id, ConstraintSet.END, layout.id, ConstraintSet.END, 32)

//      Input area Constraints

        set.connect(inputEditText.id, ConstraintSet.TOP, layout.id, ConstraintSet.TOP, 32)
        set.connect(inputEditText.id, ConstraintSet.START, layout.id, ConstraintSet.START, 32)
        set.connect(inputEditText.id, ConstraintSet.END, layout.id, ConstraintSet.END, 32)

//      Button Constraints

        set.connect(actionButton.id, ConstraintSet.TOP, layout.id, ConstraintSet.TOP, 32)
        set.connect(actionButton.id, ConstraintSet.START, layout.id, ConstraintSet.START, 32)
        set.connect(actionButton.id, ConstraintSet.END, layout.id, ConstraintSet.END, 32)

//      Applying constraints to the layout

        set.applyTo(layout)

//      Configuring the layout as the main view of the activity

        setContentView(layout)

    }
}