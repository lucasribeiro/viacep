package com.example.trabalhofinal.interfaces

import com.example.trabalhofinal.domain.CEP
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface CEPService {

    @GET("{cep}/json/")
    fun buscarCEP(@Path("cep") cep: String?): Call<CEP>
}