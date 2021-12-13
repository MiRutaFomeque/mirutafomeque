package com.myroutefomeque.mirutafomeque.data

class SitiosturisticosRepository {

    suspend fun getStiosturisticos() = ApiFactory.retrofit.getSitiosturisticos()

}