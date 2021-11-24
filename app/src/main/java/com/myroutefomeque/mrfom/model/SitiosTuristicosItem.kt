package com.myroutefomeque.mrfom.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

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
): Serializable