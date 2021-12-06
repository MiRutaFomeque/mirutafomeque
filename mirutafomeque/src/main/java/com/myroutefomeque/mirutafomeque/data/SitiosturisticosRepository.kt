package com.myroutefomeque.mirutafomeque.data

class SitiosturisticosRepository {

    suspend  fun getSitiosturisticos() = WebService.retrofit.getSitiosturisticos()
}