package com.example.counterapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.counterapp.ui.theme.CounterAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CounterAppTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    CounterApp()
                }
            }
        }
    }
}
@Composable
fun CounterApp() {
    var result by remember { mutableDoubleStateOf(0.0) }
    var input by remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
//      16 "dp" usado para layouts
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Resultado: $result",
//          24 "usado para var ou val como textos"
            fontSize = 24.sp,
            modifier = Modifier.padding(8.dp)
        )
        OutlinedTextField(
            value = input,
            onValueChange = { input = it },
            label = { Text("Digite um número") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp),modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = {
                    result += input.toDoubleOrNull() ?: 0.0
                    input = ""
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("Somar")
            }
            Button(
                onClick = {
                    result -= input.toDoubleOrNull() ?: 0.0
                    input = ""
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("Subtrair")
            }
        }
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.fillMaxWidth().padding(top = 8.dp)
        ) {
            Button(
                onClick = {
                    result *= input.toDoubleOrNull() ?: 1.0
                    input = ""
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("Multiplicar")
            }
            Button(
                onClick = {
                    val value = input.toDoubleOrNull() ?: 1.0
                    if (value != 0.0) { // regra de dividir por zero
                        result /= value
                    }
                    input = ""
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("Dividir")
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                result = 0.0
                input = ""
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Limpar")
        }
    }
}