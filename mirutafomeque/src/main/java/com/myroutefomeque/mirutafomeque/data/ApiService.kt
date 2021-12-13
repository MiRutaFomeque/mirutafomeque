package com.myroutefomeque.mirutafomeque.data

import com.myroutefomeque.mirutafomeque.model.SitiosTuristicos
import retrofit2.http.GET

interface ApiService {

    @GET("MiRutaFomeque/mirutafomeque/sitiosturisticos")
    suspend fun getSitiosturisticos(): SitiosTuristicos

}