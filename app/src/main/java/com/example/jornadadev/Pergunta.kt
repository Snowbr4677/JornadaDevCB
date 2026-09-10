package com.example.jornadadev

data class Pergunta(
    val ano: Int,
    val materia: String,
    val dificuldade: String,
    val enunciado: String,
    val opcoes: Array<String>,
    val respostaCerta: Int // Índice da alternativa certa (0, 1, 2 ou 3)
)