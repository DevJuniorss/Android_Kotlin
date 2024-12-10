package com.example.nighteventapp.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.nighteventapp.models.events

@Composable
fun EventDetailsScreen(eventId: String?) {
    val event = events.find { it.id.toString() == eventId }
    event?.let {
        Card(
            modifier = Modifier.padding(16.dp).fillMaxWidth(),
            elevation = CardDefaults.cardElevation(10.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Image(
                    painter = painterResource(id = it.imageRes),
                    contentDescription = "Imagem do evento",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxWidth().height(200.dp)
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = it.title,
                    style = MaterialTheme.typography.titleLarge
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = it.description,
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Data: ${it.date}",
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = "Local: ${it.location}",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    } ?: run {
        Text(
            text = "Evento não encontrado",
            modifier = Modifier.fillMaxWidth().padding(20.dp),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}
