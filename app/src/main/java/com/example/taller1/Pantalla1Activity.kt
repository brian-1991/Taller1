package com.example.taller1

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class Pantalla1Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PantallaHonorarios()
        }
    }
}

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaHonorarios() {
    var montoBruto by remember { mutableStateOf("") }
    var pagoLiquido by remember { mutableStateOf("") }
    var mensajeError by remember { mutableStateOf("") }
    val contexto = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = montoBruto,
            onValueChange = { montoBruto = it },
            label = { Text("Monto Bruto") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            val montoBrutoNumerico = montoBruto.toDoubleOrNull()
            if (montoBrutoNumerico != null) {
                val retencion = montoBrutoNumerico * 0.13 // 13% de retención
                pagoLiquido = "Pago Líquido: ${montoBrutoNumerico - retencion}"
                mensajeError = ""
            } else {
                mensajeError = "Por favor, ingrese un número válido."
            }
        }) {
            Text("Calcular Pago Líquido")
        }
        Text(pagoLiquido)
        if (mensajeError.isNotEmpty()) {
            Text(mensajeError, color = Color.Red)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            contexto.startActivity(Intent(contexto, MainActivity::class.java))
        }) {
            Text(text = "Volver a Inicio")
        }
    }
}
