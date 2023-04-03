package com.example.trabalhofinal.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.trabalhofinal.databinding.ActivityMainBinding
import com.example.trabalhofinal.domain.CEP
import com.example.trabalhofinal.networking.service.RetrofitConfig
import retrofit2.Call
import retrofit2.Callback;
import retrofit2.Response;
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    companion object {
        const val LOGRADOURO = "PARAMETRO_LOGRADOURO"
        const val COMPLEMENTO = "PARAMETRO_COMPLEMENTO"
        const val BAIRRO = "PARAMETRO_BAIRRO"
        const val LOCALIDADE = "PARAMETRO_LOCALIDADE"
        const val UF = "PARAMETRO_UF"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inflando o layout
        binding = ActivityMainBinding.inflate(layoutInflater)
        // Vinculando a Activity à View
        setContentView(binding.root)
        // Função utilizada para configurar os listeners.
        configurarButtomListener()

    }

    private fun configurarButtomListener() {
        binding.btnEnviar.setOnClickListener {
            binding.progressBar.visibility = View.VISIBLE

            val cepValue = binding.etCEP.text.toString();

            val call = RetrofitConfig().getCEPService().buscarCEP(cepValue)
            call.enqueue(object : Callback<CEP> {

                override fun onResponse(call: Call<CEP>, response: Response<CEP>) {
                    val endereco: CEP? = response.body()
                    binding.progressBar.visibility = View.INVISIBLE
                    if (endereco == null)
                    {
                        Toast.makeText(
                            applicationContext,
                            "CEP não encontrado!",
                            Toast.LENGTH_LONG
                        )
                            .show()
                    }
                    else {
                        val intent = Intent(applicationContext, Resultado::class.java).apply {
                            putExtra(LOGRADOURO, endereco.logradouro)
                            putExtra(COMPLEMENTO, endereco.complemento)
                            putExtra(BAIRRO, endereco.bairro)
                            putExtra(LOCALIDADE, endereco.localidade)
                            putExtra(UF, endereco.uf)
                        }
                        startActivity(intent)
                    }
                }

                override fun onFailure(call: Call<CEP>?, t: Throwable?) {
                    Toast.makeText(applicationContext, "Problema para buscar CEP!", Toast.LENGTH_LONG)
                        .show()
                    binding.progressBar.visibility = View.INVISIBLE
                }
            })
        }
    }
}