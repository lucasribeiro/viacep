package com.example.trabalhofinal.domain

import kotlinx.android.parcel.Parcelize

@Parcelize
class CEP {
    var cep: String? = ""
    var logradouro: String? = ""
    var complemento: String? = ""
    var bairro: String? = ""
    var localidade: String? = ""
    var uf: String? = ""
    var unidade: String? = ""
    var ibge: String? = ""
    var gia: String? = ""
}