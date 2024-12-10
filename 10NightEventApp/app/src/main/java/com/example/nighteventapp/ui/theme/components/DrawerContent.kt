package com.example.nighteventapp.ui.theme.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun DrawerContent(navController: NavHostController, onSendNotification: () -> Unit) {
    Surface(
        modifier = Modifier.fillMaxHeight().width(380.dp).padding().background(MaterialTheme.colorScheme.surface),color = MaterialTheme.colorScheme.surface
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(20.dp)
        ) {
            Text(
                text = "Menu",
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier.padding(bottom = 16.dp)
            )
//          Divider ele da warn ent troquei pelo divisor horizontal
//          Divider()
            HorizontalDivider()
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Perfil",
                modifier = Modifier.fillMaxWidth().clickable { }.padding(vertical = 10.dp)
            )
            Text(
                text = "Notificação",
                modifier = Modifier.fillMaxWidth().clickable {}.padding(vertical = 10.dp)
            )
            Text(
                text = "Sair",
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.clickable {}.padding(vertical = 10.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "Versão 0.0.0.1",
                modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp)
            )
        }
    }
}