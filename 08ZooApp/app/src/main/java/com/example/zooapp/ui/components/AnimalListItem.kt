package com.example.zooapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.zooapp.Models.Animal

class AnimalListItem {
}
@Composable
fun  AnimalListItem(animal: Animal, onAnimalSeleted: (Animal) -> Unit){
    Card(modifier = Modifier.fillMaxSize().padding(10.dp), elevation = CardDefaults.cardElevation(5.dp)) {
        Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = animal.imageRes),
                    contentDescription = "${animal.name} Image", modifier = Modifier.size(80.dp).clip(CircleShape))
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(text = animal.name, style = MaterialTheme.typography.bodySmall)
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = animal.description, style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Curiosidades: ${animal.curiosities}", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.secondary)
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = {onAnimalSeleted(animal)}) {
                Text("Mais sobre: ${animal.name}")
            }
        }
    }
}