package com.example.jornadadev

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class QuizActivity : AppCompatActivity() {

    // Banco de Perguntas Integrado
    // Banco de Perguntas Integrado (Ajustado para a grade correta)
    private val listaPerguntas = listOf(
        // ANO 1 - Lógica e Linguagem de Programação (Algoritmos e Lógica)
        Pergunta(
            1, "LLP",
            "Qual estrutura de controle é utilizada para repetir um bloco de código enquanto uma condição for verdadeira?",
            arrayOf("se/senão (if/else)", "enquanto (while)", "escolha (switch/when)", "retorne (return)"),
            1
        ),
        // ANO 1 - Processos de Desenvolvimento de Software e Metodologias Ágeis
        Pergunta(
            1, "PDSMA",
            "No framework Scrum, qual cerimônia diária e rápida alinha as atividades da equipe?",
            arrayOf("Sprint Review", "Sprint Planning", "Daily Scrum", "Sprint Retrospective"),
            2
        ),
        // ANO 1 - Redes de Computadores e Segurança da Informação
        Pergunta(
            1, "RCSIN",
            "Qual serviço de rede é responsável por converter nomes de domínio amigáveis (como www.exemplo.com) em endereços IP?",
            arrayOf("DHCP", "DNS", "FTP", "SMTP"),
            1
        ),
        // ANO 1 - Carreiras e Competências
        Pergunta(
            1, "Carreiras",
            "Qual termo define as habilidades comportamentais e interpessoais de um profissional no mercado de trabalho?",
            arrayOf("Hard Skills", "Technical Skills", "Soft Skills", "Backlog Skills"),
            2
        ),
        // ANO 2 - Modelagem e Desenvolvimento de Banco de Dados
        Pergunta(
            2, "MBD",
            "Qual comando da linguagem SQL é utilizado para extrair dados de uma tabela existente?",
            arrayOf("INSERT INTO", "UPDATE", "DROP TABLE", "SELECT"),
            3
        ),
        // ANO 2 - Programação Mobile
        Pergunta(
            2, "PM",
            "No desenvolvimento nativo Android, qual função associa o arquivo de layout XML à sua Activity?",
            arrayOf("findViewById()", "setContentView()", "startActivity()", "finish()"),
            1
        ),
        // ANO 2 - Programação Frontend
        Pergunta(
            2, "Front-End",
            "No desenvolvimento web, qual linguagem é responsável por definir a estrutura semântica dos elementos na página?",
            arrayOf("CSS", "JavaScript", "HTML", "TypeScript"),
            2
        ),
        // ANO 2 - Programação Backend
        Pergunta(
            2, "Back-End",
            "Qual protocolo é o padrão da web para comunicação e troca de requisições/respostas entre cliente e servidor?",
            arrayOf("HTTP/HTTPS", "SSH", "IMAP", "UDP"),
            0
        ),
        // ANO 2 - Versionamento de Código e Sistemas de Mensageria
        Pergunta(
            2, "VCSM",
            "No Git, qual comando grava as alterações adicionadas na área de preparação localmente no repositório?",
            arrayOf("git push", "git commit", "git pull", "git status"),
            1
        ),
        // ANO 2 - Inteligência Artificial
        Pergunta(
            2, "IA",
            "Qual ramo da IA treina algoritmos para reconhecer padrões e tomar decisões a partir de conjuntos de dados?",
            arrayOf("Engenharia Reversa", "Compilação JIT", "Machine Learning (Aprendizado de Máquina)", "Criptografia"),
            2
        ),
        // ANO 2 - Projeto Multidisciplinar
        Pergunta(
            2, "PMD",
            "Qual é o artefato central que reúne a documentação de requisitos, objetivos e regras de negócio de um projeto de software?",
            arrayOf("Briefing / Escopo do Projeto", "Arquivo de Log", "Driver de Hardware", "Branch Master"),
            0
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        val txtMateria = findViewById<TextView>(R.id.txtQuizMateria)
        val txtEnunciado = findViewById<TextView>(R.id.txtEnunciado)
        val btnOpcao0 = findViewById<Button>(R.id.btnOpcao0)
        val btnOpcao1 = findViewById<Button>(R.id.btnOpcao1)
        val btnOpcao2 = findViewById<Button>(R.id.btnOpcao2)
        val btnOpcao3 = findViewById<Button>(R.id.btnOpcao3)

        // Recupera o que foi selecionado
        val ano = intent.getIntExtra("EXTRA_ANO", 1)
        val materia = intent.getStringExtra("EXTRA_MATERIA") ?: "LLP"

        txtMateria.text = "Disciplina: $materia (Ano $ano)"

        // Busca a pergunta que bate com a matéria escolhida
        val perguntaAtual = listaPerguntas.find { it.materia == materia }

        if (perguntaAtual != null) {
            txtEnunciado.text = perguntaAtual.enunciado
            btnOpcao0.text = perguntaAtual.opcoes[0]
            btnOpcao1.text = perguntaAtual.opcoes[1]
            btnOpcao2.text = perguntaAtual.opcoes[2]
            btnOpcao3.text = perguntaAtual.opcoes[3]

            // Validação de resposta nos cliques
            val botoes = listOf(btnOpcao0, btnOpcao1, btnOpcao2, btnOpcao3)
            for (i in botoes.indices) {
                botoes[i].setOnClickListener {
                    if (i == perguntaAtual.respostaCerta) {
                        Toast.makeText(this, "Acertou! Parabéns!", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "Errou! Tente novamente.", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        } else {
            txtEnunciado.text = "Ainda não há perguntas cadastradas para esta matéria."
            btnOpcao0.isEnabled = false
            btnOpcao1.isEnabled = false
            btnOpcao2.isEnabled = false
            btnOpcao3.isEnabled = false
        }
    }
}