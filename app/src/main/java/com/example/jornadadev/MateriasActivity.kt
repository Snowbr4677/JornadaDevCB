package com.example.jornadadev

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MateriasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_materias)

        val containerAno1 = findViewById<LinearLayout>(R.id.containerAno1)
        val containerAno2 = findViewById<LinearLayout>(R.id.containerAno2)
        val txtTitulo = findViewById<TextView>(R.id.txtTituloMaterias)

        val anoEscolhido = intent.getIntExtra("EXTRA_ANO", 1)

        if (anoEscolhido == 1) {
            txtTitulo.text = "Disciplinas - 1º Ano"
            containerAno1.visibility = View.VISIBLE
            containerAno2.visibility = View.GONE
        } else {
            txtTitulo.text = "Disciplinas - 2º Ano"
            containerAno1.visibility = View.GONE
            containerAno2.visibility = View.VISIBLE
        }

        // --- Cliques Ano 1 ---
        findViewById<Button>(R.id.btnLLP).setOnClickListener { abrirDificuldade(anoEscolhido, "LLP") }
        findViewById<Button>(R.id.btnPDSMA).setOnClickListener { abrirDificuldade(anoEscolhido, "PDSMA") }
        findViewById<Button>(R.id.btnRCSIN).setOnClickListener { abrirDificuldade(anoEscolhido, "RCSIN") }
        findViewById<Button>(R.id.btnCarreiras).setOnClickListener { abrirDificuldade(anoEscolhido, "Carreiras") }

        // --- Cliques Ano 2 ---
        findViewById<Button>(R.id.btnMBD).setOnClickListener { abrirDificuldade(anoEscolhido, "MBD") }
        findViewById<Button>(R.id.btnPM).setOnClickListener { abrirDificuldade(anoEscolhido, "PM") }
        findViewById<Button>(R.id.btnFront).setOnClickListener { abrirDificuldade(anoEscolhido, "Front-End") }
        findViewById<Button>(R.id.btnBack).setOnClickListener { abrirDificuldade(anoEscolhido, "Back-End") }
        findViewById<Button>(R.id.btnVCSM).setOnClickListener { abrirDificuldade(anoEscolhido, "VCSM") }
        findViewById<Button>(R.id.btnIA).setOnClickListener { abrirDificuldade(anoEscolhido, "IA") }
        findViewById<Button>(R.id.btnPMD).setOnClickListener { abrirDificuldade(anoEscolhido, "PMD") }
    }

    private fun abrirDificuldade(ano: Int, materia: String) {
        Toast.makeText(this, "Selecionado: $materia (Ano $ano)", Toast.LENGTH_SHORT).show()
        // Próximo passo quando criarmos a DificuldadeActivity:
        // val intent = Intent(this, DificuldadeActivity::class.java)
        // intent.putExtra("EXTRA_ANO", ano)
        // intent.putExtra("EXTRA_MATERIA", materia)
        // startActivity(intent)
    }
}