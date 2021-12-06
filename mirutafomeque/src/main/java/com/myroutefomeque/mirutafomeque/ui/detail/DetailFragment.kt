package com.myroutefomeque.mirutafomeque.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.myroutefomeque.mirutafomeque.R
import com.myroutefomeque.mirutafomeque.databinding.FragmentDetailBinding
import com.myroutefomeque.mirutafomeque.ui.main.MainActivity
import com.squareup.picasso.Picasso


class DetailFragment : Fragment() {

    private lateinit var detailBinding: FragmentDetailBinding
    private val detailViewModel: DetailViewModel by viewModels()
    private val args:DetailFragmentArgs by navArgs()

    private val callback = OnMapReadyCallback { googleMap ->

        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        val sitiosturisticos = args.sitio
        val lugarmap = LatLng(sitiosturisticos.latitud,sitiosturisticos.longitud)
        googleMap.addMarker(MarkerOptions().position(lugarmap).title(sitiosturisticos.nombre).snippet(sitiosturisticos.ubicacion))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lugarmap, sitiosturisticos.zoommap))
    }





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //(activity as MainActivity?)?.showIcon() No se usa en drawer activity
        (activity as MainActivity?)?.showIcon()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        detailBinding = FragmentDetailBinding.inflate(inflater, container, false)
        //Se puede borrar esta linea en la forma en que se definio en la parte de arriba de este codigo detailViewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        return detailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sitiosturisticos = args.sitio

        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)

        with(detailBinding){
            nameTextView.text = sitiosturisticos.nombre
            temperatureTextView.text = sitiosturisticos.temperatura.toString()
            puntajeTextView.text = sitiosturisticos.puntuacion.toString()
            locationTextView.text = sitiosturisticos.ubicacion
            descriptionTextView.text = sitiosturisticos.infoGeneral
            sitioRecTextView.text = sitiosturisticos.sitiosRecomendados
            Picasso.get().load(sitiosturisticos.urlPicture).into(pictureImageView)
            //Picasso.get().load(sitiosturisticos.urlPicture).into(pictureImageView)

            mapButton.setOnClickListener{
                findNavController().navigate(DetailFragmentDirections.actionNavigationDetailToMapsFragment(sitiosturisticos))
            }
        }

    }

}