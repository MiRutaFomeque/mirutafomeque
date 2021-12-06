package com.myroutefomeque.mirutafomeque.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.myroutefomeque.mirutafomeque.data.SitiosturisticosRepository
import com.myroutefomeque.mirutafomeque.model.SitiosTuristicos
import com.myroutefomeque.mirutafomeque.model.SitiosTuristicosItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.InputStream

class ListViewModel : ViewModel() {
    private var sitiosturisticosLoad : MutableLiveData<ArrayList<SitiosTuristicosItem>> = MutableLiveData()
    val onSitiosTuristicosLoaded : LiveData<ArrayList<SitiosTuristicosItem>> = sitiosturisticosLoad

    private val repository = SitiosturisticosRepository()

    fun getSitiosturisticosFromServer(){
        GlobalScope.launch(Dispatchers.IO) {
            sitiosturisticosLoad.postValue(repository.getSitiosturisticos())
        }
    }

    fun loadMockListaSitiosFromJson(listaSitiosTurString: InputStream?){
        val listaSitiosTursString = listaSitiosTurString?.bufferedReader().use { it!!.readText() }
        val gson = Gson()
        sitiosturisticosLoad.value = gson.fromJson(listaSitiosTursString, SitiosTuristicos::class.java)
    }
}