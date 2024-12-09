package com.example.animalapp

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.animalapp.ui.theme.AnimalAppTheme

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimalAppTheme {
                AnimalApp()
            }
        }
    }
}
@Composable
@ExperimentalMaterial3Api
fun HomeScreen(onAnimalSelected: (String) -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("AnimalApp") },
                actions = { AnimalMenuApp(onOptionSelected = onAnimalSelected) }
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier.fillMaxWidth().padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            Text("Selecione um animal.")
        }
    }
}
@Composable
fun AnimalMenuApp(onOptionSelected: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }

    IconButton(onClick = { expanded = true }) {
        Icon(Icons.Default.MoreVert, contentDescription = "Menu")
    }
    DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
        DropdownMenuItem(
            text = { Text("Lobo") },
            onClick = {
                expanded = false
                onOptionSelected("Lobo")
            }
        )
        DropdownMenuItem(
            text = { Text("Cordeiro") },
            onClick = {
                expanded = false
                onOptionSelected("Cordeiro")
            }
        )
    }
}
@Composable
fun AnimalScreen(animal: String) {
    val context = LocalContext.current
    val imageRes = if (animal == "Lobo") R.drawable.lobo else R.drawable.cordeiro
    val soundRes = if (animal == "Lobo") R.raw.lobo_audio else R.raw.cordeiro_audio
    val videoRes = if (animal == "Lobo") R.raw.lobo_vid else R.raw.cordeiro_vid

    Column(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = "$animal Image",
            modifier = Modifier.size(200.dp).clip(CircleShape)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            var mediaPlayer: MediaPlayer? = null
            try {
                mediaPlayer = MediaPlayer.create(context, soundRes)
                mediaPlayer?.start()
                mediaPlayer?.setOnCompletionListener { it.release() }
            } catch (e: Exception) {
                println("Erro ao inicializar MediaPlayer: ${e.message}")
            } finally {
                mediaPlayer?.release()
            }
        }) {
            Text("Reproduzir Som")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            val intent = Intent(context, VideoPlayerActivity::class.java)
            intent.putExtra("videoRes", videoRes)
            context.startActivity(intent)
        }) {
            Text("Reproduzir Vídeo")
        }
    }
}
@ExperimentalMaterial3Api
@Composable
fun AnimalApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(onAnimalSelected = { animal ->
                navController.navigate("animal/$animal")
            })
        }
        composable(
            "animal/{animal}",
            arguments = listOf(navArgument("animal") { type = NavType.StringType })
        ) { backStackEntry ->
            val animal = backStackEntry.arguments?.getString("animal") ?: "Lobo"
            AnimalScreen(animal)
        }
    }
}
@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun AnimalAppMenuPreview() {
    AnimalAppTheme {
        AnimalScreen("dog")
    }
}