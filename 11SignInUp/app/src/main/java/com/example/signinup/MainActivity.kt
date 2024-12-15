package com.example.signinup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.signinup.ui.navigation.Navigation
import com.example.signinup.ui.theme.SignInUpTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SignInUpTheme {
                Navigation()
            }
        }
    }
}