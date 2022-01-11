package com.example.recyclerview

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // definindo que a variável motoAdapter será inicializada após o ciclo do onCreate e criando o vinculo de herança das funções de adapter do recyclerview.
    private lateinit var motoAdapter: MotoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Estou executando as funções e criando as mesmas logo em sequência.
        initRecyclerView()
        addDataSource()
    }

    // função que executa uma nova criação de um conjunto de dados para uma fonte de dados e libera este acesso para a variavel motoAdapter.
    private fun addDataSource() {
        val dataSource = DataSource.createDataSet()
        this.motoAdapter.setDataSet(dataSource)
    }

    // inicilizando a recyclerView
    private fun initRecyclerView() {

        // neste bloco executa o setOnClickListener definido dentro do adapter.
        this.motoAdapter = MotoAdapter { moto ->

            openLink(moto.link)
        }

        // neste bloco eu defino em qual contexto esotu operando o layout manager e defino qual vai ser o adapter que vai executar as funções do recyclerView.
        recyclerview.apply{
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = motoAdapter

        }
    }

    // Está função tem o objetivo de configurar a abertura do link por meio da leitura de uma String e inciar a atividade intencionada.
    private fun openLink(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
}