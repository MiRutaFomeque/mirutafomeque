package com.myroutefomeque.mirutafomeque.list


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewTreeLifecycleOwner
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.myroutefomeque.mirutafomeque.databinding.FragmentListBinding
import com.myroutefomeque.mirutafomeque.main.MainActivity
import com.myroutefomeque.mirutafomeque.model.SitiosTuristicosItem


class ListFragment : Fragment() {

    private lateinit var listBinding: FragmentListBinding
    private lateinit var listViewModel: ListViewModel
    private lateinit var sitiosTuristicosAdapter: SitiosturisticosAdapter
    private var listSitiosGl: ArrayList<SitiosTuristicosItem> = arrayListOf()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        listBinding = FragmentListBinding.inflate(inflater, container, false)
        listViewModel = ViewModelProvider(this)[ListViewModel::class.java]
        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //(activity as MainActivity?)?.hideIcon() //No se usa en drawer activity
        listViewModel.loadMockListaSitiosFromJson(context?.assets?.open("sitiosTuristicos.json"))

        listViewModel.onSitiosTuristicosLoaded.observe(viewLifecycleOwner,{ result ->
            onSitiosTuristicosLoadedSubscribe(result)

        })

            sitiosTuristicosAdapter = SitiosturisticosAdapter( listSitiosGl, onItemClicked = { onSitiosTuristicosClicked(it) })

            listBinding.listaSitiosRecyclerView.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = sitiosTuristicosAdapter
                setHasFixedSize(false)
            }




    }

    private fun onSitiosTuristicosLoadedSubscribe(result: ArrayList<SitiosTuristicosItem>?) {
        result?.let { listSitiosLoc ->

            sitiosTuristicosAdapter.appendItems(listSitiosLoc)

            /*
            //TODO: Revisar feedback
            this.listSitiosGl = listSitiosLoc
            sitiosTuristicosAdapter.notifyDataSetChanged()*/
        }

    }

    private fun onSitiosTuristicosClicked(sitiosturisticos: SitiosTuristicosItem) {
        findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(sitio = sitiosturisticos))
        //linea que prueba el preferencefragment //findNavController().navigate(ListFragmentDirections.actionListFragmentToSettingsFragment())
    }
    //Se quita y se pone en el archivo viewModel al refactorizar el codigo para implementar viewModel, Nota: verificar que el viewModel funciona con los demas diseños de la app
    /*private fun loadMockListaSitiosFromJson(): ArrayList<SitiosTuristicosItem> {
        val listaSitiosTurString : String = context?.assets?.open("sitiosTuristicos.json")?.bufferedReader().use { it!!.readText() } //TODO reparar!!
        //El contexto cambia dentro del fragment, no se va a llamar applicationContext.assets, sino context?.assets?
         /* var listaSitiosTurString : String = applicationContext.assets.open("sitiosTuristicos.json").bufferedReader().use { it.readText() }*/
        val gson = Gson()
        val data = gson.fromJson(listaSitiosTurString, SitiosTuristicos::class.java)
        return data
    }*/


}