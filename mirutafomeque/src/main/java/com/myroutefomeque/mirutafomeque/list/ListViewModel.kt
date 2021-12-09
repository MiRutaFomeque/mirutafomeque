package com.myroutefomeque.mirutafomeque.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.myroutefomeque.mirutafomeque.model.SitiosTuristicos
import com.myroutefomeque.mirutafomeque.model.SitiosTuristicosItem
import java.io.InputStream

class ListViewModel : ViewModel() {

    private var sitiosLoad = MutableLiveData<ArrayList<SitiosTuristicosItem>>()
    val onSitiosLoaded : LiveData<ArrayList<SitiosTuristicosItem>> = sitiosLoad


    fun loadMockListaSitiosFromJson(listaSitiosTurString: InputStream?) {
        val listaSitiosTurString = listaSitiosTurString?.bufferedReader().use { it!!.readText() }
        //El contexto cambia dentro del fragment, no se va a llamar applicationContext.assets, sino context?.assets?
        /* var listaSitiosTurString : String = applicationContext.assets.open("sitiosTuristicos.json").bufferedReader().use { it.readText() }*/
        val gson = Gson()
        sitiosLoad.value = gson.fromJson(listaSitiosTurString, SitiosTuristicos::class.java)
    }

}