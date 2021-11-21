package com.myroutefomeque.mrfom


import com.google.gson.annotations.SerializedName

data class SitiosTuristicosItem(
    @SerializedName("infoGeneral")
    val infoGeneral: String,
    @SerializedName("nombre")
    val nombre: String,
    @SerializedName("puntuacion")
    val puntuacion: Int,
    @SerializedName("sitiosRecomendados")
    val sitiosRecomendados: String,
    @SerializedName("temperatura")
    val temperatura: Int,
    @SerializedName("ubicacion")
    val ubicacion: String,
    @SerializedName("urlPicture")
    val urlPicture: String
)