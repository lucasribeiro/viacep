package com.example.trabalhofinal.ui

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.example.trabalhofinal.R
import com.example.trabalhofinal.databinding.ActivityResultadoBinding
import com.example.trabalhofinal.ui.MainActivity.Companion.BAIRRO
import com.example.trabalhofinal.ui.MainActivity.Companion.COMPLEMENTO
import com.example.trabalhofinal.ui.MainActivity.Companion.LOCALIDADE
import com.example.trabalhofinal.ui.MainActivity.Companion.LOGRADOURO
import com.example.trabalhofinal.ui.MainActivity.Companion.UF

class Resultado : AppCompatActivity() {

    private lateinit var binding: ActivityResultadoBinding
    var logradouro = ""
    var complemento = ""
    var bairro = ""
    var localidade = ""
    var uf = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultadoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        inicializarVariaveis()

        popularTela()

        configurarButtomListener()
    }

    private fun configurarButtomListener() {
        binding.btnRetornar.setOnClickListener {
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
    }


    private fun inicializarVariaveis()
    {
        logradouro = intent.getStringExtra(LOGRADOURO).toString()
        complemento = intent.getStringExtra(COMPLEMENTO).toString()
        bairro = intent.getStringExtra(BAIRRO).toString()
        localidade = intent.getStringExtra(LOCALIDADE).toString()
        uf = intent.getStringExtra(UF).toString()
    }

    private fun popularTela() {
        binding.tvLogradouro.text = logradouro
        binding.tvComplemento.text = complemento
        binding.tvBairro.text = bairro
        binding.tvLocalidade.text = localidade
        binding.tvUF.text = uf
    }
}