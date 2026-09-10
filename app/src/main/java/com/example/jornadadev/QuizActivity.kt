package com.example.jornadadev

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class QuizActivity : AppCompatActivity() {

    // 1. Banco de perguntas completo
    private val todasPerguntas = listOf(
        // --- VCSM ---
        Pergunta(2, "VCSM", "Trainee", "Qual é a principal função do GitHub?", arrayOf("Criar bancos de dados.", "Hospedar e versionar projetos de código.", "Fazer desenhos de interface.", "Programar aplicativos sem código."), 1),
        Pergunta(2, "VCSM", "Júnior", "O que faz o comando git push?", arrayOf("Baixa o projeto.", "Envia as alterações para o GitHub.", "Apaga o repositório.", "Cria uma branch."), 1),
        Pergunta(2, "VCSM", "Pleno", "O que é uma branch?", arrayOf("Uma cópia paralela do projeto.", "Um banco de dados.", "Um arquivo HTML.", "Um servidor."), 0),

        // --- FRONT-END ---
        Pergunta(2, "Front-End", "Trainee", "Qual linguagem estrutura uma página web?", arrayOf("CSS", "JavaScript", "HTML", "SQL"), 2),
        Pergunta(2, "Front-End", "Júnior", "Qual é a função do CSS?", arrayOf("Criar banco de dados.", "Estilizar a página.", "Fazer login.", "Enviar dados ao servidor."), 1),
        Pergunta(2, "Front-End", "Pleno", "O que significa uma página responsiva?", arrayOf("Funciona apenas no celular.", "Adapta-se a diferentes tamanhos de tela.", "Carrega mais rápido.", "Não usa CSS."), 1),

        // --- BACK-END ---
        Pergunta(2, "Back-End", "Trainee", "Qual é a função do back-end?", arrayOf("Criar a aparência da página.", "Processar dados e regras do sistema.", "Editar imagens.", "Criar planilhas."), 1),
        Pergunta(2, "Back-End", "Júnior", "O que é uma API?", arrayOf("Um tipo de banco de dados.", "Uma ponte de comunicação entre sistemas.", "Um editor de código.", "Um navegador."), 1),
        Pergunta(2, "Back-End", "Pleno", "O que é autenticação?", arrayOf("Alterar a cor do site.", "Verificar a identidade do usuário.", "Criar uma tabela.", "Fazer backup."), 1),

        // --- MBD ---
        Pergunta(2, "MBD", "Trainee", "O que é uma entidade?", arrayOf("Um computador.", "Um objeto representado no banco de dados.", "Uma senha.", "Um navegador."), 1),
        Pergunta(2, "MBD", "Júnior", "O que é um relacionamento?", arrayOf("Ligação entre entidades.", "Nome da tabela.", "Tipo de arquivo.", "Um programa."), 0),
        Pergunta(2, "MBD", "Pleno", "Para que serve um DER?", arrayOf("Programar em Java.", "Modelar entidades e relacionamentos do banco.", "Criar páginas HTML.", "Fazer testes."), 1)
    )

    // Lista filtrada apenas com as perguntas da matéria clicada
    private var perguntasDaMateria: List<Pergunta> = emptyList()
    private var indiceAtual = 0

    // Elementos da interface
    private lateinit var txtMateria: TextView
    private lateinit var txtEnunciado: TextView
    private lateinit var botoesOpcoes: List<Button>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        txtMateria = findViewById(R.id.txtQuizMateria)
        txtEnunciado = findViewById(R.id.txtEnunciado)
        botoesOpcoes = listOf(
            findViewById(R.id.btnOpcao0),
            findViewById(R.id.btnOpcao1),
            findViewById(R.id.btnOpcao2),
            findViewById(R.id.btnOpcao3)
        )

        val materiaSelecionada = intent.getStringExtra("EXTRA_MATERIA") ?: "VCSM"

        // Filtra só as perguntas da matéria escolhida
        perguntasDaMateria = todasPerguntas.filter { it.materia == materiaSelecionada }

        if (perguntasDaMateria.isNotEmpty()) {
            carregarPergunta()
        } else {
            txtEnunciado.text = "Em breve: perguntas cadastradas pela turma!"
            botoesOpcoes.forEach { it.isEnabled = false }
        }
    }

    private fun carregarPergunta() {
        val pergunta = perguntasDaMateria[indiceAtual]

        txtMateria.text = "${pergunta.materia} - Nível ${pergunta.dificuldade} (${indiceAtual + 1}/${perguntasDaMateria.size})"
        txtEnunciado.text = pergunta.enunciado

        for (i in botoesOpcoes.indices) {
            botoesOpcoes[i].text = pergunta.opcoes[i]
            botoesOpcoes[i].isEnabled = true
            botoesOpcoes[i].setOnClickListener {
                verificarResposta(i, pergunta.respostaCerta)
            }
        }
    }

    private fun verificarResposta(opcaoEscolhida: Int, respostaCerta: Int) {
        if (opcaoEscolhida == respostaCerta) {
            Toast.makeText(this, "Acertou! Boa!", Toast.LENGTH_SHORT).show()
            indiceAtual++

            if (indiceAtual < perguntasDaMateria.size) {
                carregarPergunta() // Vai para a próxima (ex: Júnior ou Pleno)
            } else {
                Toast.makeText(this, "Parabéns! Você concluiu todas as questões dessa disciplina!", Toast.LENGTH_LONG).show()
                finish() // Volta para a tela de matérias
            }
        } else {
            Toast.makeText(this, "Resposta errada! Tente novamente.", Toast.LENGTH_SHORT).show()
        }
    }
}