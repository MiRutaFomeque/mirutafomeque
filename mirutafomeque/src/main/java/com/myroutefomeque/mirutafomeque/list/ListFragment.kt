package com.myroutefomeque.mirutafomeque.list


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.myroutefomeque.mirutafomeque.databinding.FragmentListBinding
import com.myroutefomeque.mirutafomeque.model.SitiosTuristicosItem


class ListFragment : Fragment() {

    private lateinit var listBinding: FragmentListBinding
    private val listViewModel: ListViewModel by viewModels()
    private lateinit var sitiosTuristicosAdapter: SitiosturisticosAdapter
    private var listSitios: ArrayList<SitiosTuristicosItem> = arrayListOf()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        listBinding = FragmentListBinding.inflate(inflater, container, false)
        //listViewModel = ViewModelProvider(this)[ListViewModel::class.java]
        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //(activity as MainActivity?)?.hideIcon() No se usa en drawer activity
        listViewModel.loadMockListaSitiosFromJson(context?.assets?.open("sitiosTuristicos.json"))

        listViewModel.onSitiosLoaded.observe(viewLifecycleOwner, { result ->
            onSitiosLoadedSubscribe(result)
        })

        sitiosTuristicosAdapter = SitiosturisticosAdapter(listSitios, onItemClicked = { onSitiosTuristicosClicked(it) })

        listBinding.listaSitiosRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = sitiosTuristicosAdapter
            setHasFixedSize(false)
        }
    }

    private fun onSitiosLoadedSubscribe(result: ArrayList<SitiosTuristicosItem>?) {
        result?.let { listSitios ->
            sitiosTuristicosAdapter.appendItems(listSitios)
            /*
            this.listSitios = listSitios
            sitiosTuristicosAdapter.notifyDataSetChanged()*/
        }
    }

    private fun onSitiosTuristicosClicked(sitiosturisticos: SitiosTuristicosItem) {
        findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(sitio = sitiosturisticos))
        //linea que prueba el preferencefragment //findNavController().navigate(ListFragmentDirections.actionListFragmentToSettingsFragment())
    }

}