package com.example.taller1

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.taller1.ui.theme.Taller1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PantallaInicio()
        }
    }
}

@Preview
@Composable
fun PantallaInicio() {
    val contexto = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            val intent = Intent(contexto, Pantalla1Activity::class.java)
            contexto.startActivity(intent)
        }) {
            Text("Honorarios")
        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            val intent = Intent(contexto, Pantalla2Activity::class.java)
            contexto.startActivity(intent)
        }) {
            Text("Regulares Contrato")
        }
    }
}
