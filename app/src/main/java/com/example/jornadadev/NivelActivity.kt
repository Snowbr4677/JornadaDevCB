package com.example.jornadadev

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class NivelActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nivel)

        val btnNivel1 = findViewById<Button>(R.id.btnNivel1)
        val btnNivel2 = findViewById<Button>(R.id.btnNivel2)

        btnNivel1.setOnClickListener {
            val intent = Intent(this, MateriasActivity::class.java)
            intent.putExtra("EXTRA_ANO", 1)
            startActivity(intent)
        }

        btnNivel2.setOnClickListener {
            val intent = Intent(this, MateriasActivity::class.java)
            intent.putExtra("EXTRA_ANO", 2)
            startActivity(intent)
        }
    }
}