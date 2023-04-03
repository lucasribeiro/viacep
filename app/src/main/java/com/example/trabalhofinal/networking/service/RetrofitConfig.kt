package com.example.trabalhofinal.networking.service

import com.example.trabalhofinal.interfaces.CEPService
import com.example.trabalhofinal.networking.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConfig {

    fun init() {
    }
    val http = OkHttpClient.Builder()
    val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(http.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun getCEPService(): CEPService {
        return retrofit.create(CEPService::class.java)
    }
}