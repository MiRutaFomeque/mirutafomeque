package com.myroutefomeque.mrfom


import com.google.gson.annotations.SerializedName

/*
 //Codigo anterior para cargar una lista quemada
class SitiosTuristicos(
   val nombre: String,
   val infoGeneral: String,
   val ubicacion: String,
   val temperatura: Int,
   val sitiosRecomendados: String,
   val puntuacion: Int,
   val urlPicture: String

)*/



class SitiosTuristicos : ArrayList<SitiosTuristicosItem>()