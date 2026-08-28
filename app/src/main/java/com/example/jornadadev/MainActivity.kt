package com.example.jornadadev

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Mapeia o botão pelo ID definido no XML
        val btnIniciar = findViewById<Button>(R.id.btnIniciar)

        // Ao clicar, abre a tela de níveis
        btnIniciar.setOnClickListener {
            val intent = Intent(this, NivelActivity::class.java)
            startActivity(intent)
        }
    }
}