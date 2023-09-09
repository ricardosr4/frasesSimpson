package com.example.frasessimpsonapp.model

import com.google.gson.annotations.SerializedName

data class Personaje(
    @SerializedName("quote")
    val frase:String,
    @SerializedName("character")
    val personaje:String,
    @SerializedName("image")
    val imagen:String,
    @SerializedName("characterDirection")
    val direccionPersonaje:String

)
