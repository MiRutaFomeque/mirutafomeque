package com.myroutefomeque.mirutafomeque.list


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.Gson
import com.myroutefomeque.mirutafomeque.databinding.FragmentListBinding
import com.myroutefomeque.mirutafomeque.model.SitiosTuristicos
import com.myroutefomeque.mirutafomeque.model.SitiosTuristicosItem


class ListFragment : Fragment() {

    private lateinit var listBinding: FragmentListBinding
    private lateinit var sitiosTuristicosAdapter: SitiosturisticosAdapter
    private lateinit var listSitios: ArrayList<SitiosTuristicosItem>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        listBinding = FragmentListBinding.inflate(inflater, container, false)
        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listSitios = loadMockListaSitiosFromJson()
        sitiosTuristicosAdapter = SitiosturisticosAdapter(listSitios, onItemClicked = { onSitiosTuristicosClicked(it) })
    }

    private fun onSitiosTuristicosClicked(sitiosturisticos: SitiosTuristicosItem) {
    // TODO programar detalle
    }

    private fun loadMockListaSitiosFromJson(): ArrayList<SitiosTuristicosItem> {
        var listaSitiosTurString : String = context?.assets?.open("sitiosTuristicos.json")?.bufferedReader().use { it!!.readText() } //TODO reparar!!
        //El contexto cambia dentro del fragment, no se va a llamar applicationContext.assets, sino context?.assets?
         /* var listaSitiosTurString : String = applicationContext.assets.open("sitiosTuristicos.json").bufferedReader().use { it.readText() }*/
        val gson = Gson()
        val data = gson.fromJson(listaSitiosTurString, SitiosTuristicos::class.java)
        return data
    }
}