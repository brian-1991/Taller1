package com.example.taller1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Pantalla2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla2)

        val etMontoBruto = findViewById<EditText>(R.id.etMontoBruto)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val tvPagoLiquido = findViewById<TextView>(R.id.tvPagoLiquido)
        val btnVolver = findViewById<Button>(R.id.btnVolver)

        btnCalcular.setOnClickListener {
            val montoBruto = etMontoBruto.text.toString().toDoubleOrNull()
            if (montoBruto != null) {
                val retencion = montoBruto * 0.20 // 20% de retención
                val pagoLiquido = montoBruto - retencion
                tvPagoLiquido.text = "Pago Líquido: $pagoLiquido"
            }
        }

        btnVolver.setOnClickListener {
            finish()
        }
    }
}
