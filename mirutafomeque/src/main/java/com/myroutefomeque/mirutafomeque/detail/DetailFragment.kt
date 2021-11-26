package com.myroutefomeque.mirutafomeque.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.myroutefomeque.mirutafomeque.databinding.FragmentDetailBinding
import com.squareup.picasso.Picasso


class DetailFragment : Fragment() {
    private val args:DetailFragmentArgs by navArgs()
    private lateinit var detailBinding: FragmentDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        detailBinding = FragmentDetailBinding.inflate(inflater, container, false)
        return detailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sitiosturisticos = args.sitio

        with(detailBinding){
            nameTextView.text = sitiosturisticos.nombre
            temperatureTextView.text = sitiosturisticos.temperatura.toString()
            puntajeTextView.text = sitiosturisticos.puntuacion.toString()
            locationTextView.text = sitiosturisticos.ubicacion
            descriptionTextView.text = sitiosturisticos.infoGeneral
            sitioRecTextView.text = sitiosturisticos.sitiosRecomendados
            com.squareup.picasso.Picasso.get().load(sitiosturisticos.urlPicture).into(pictureImageView)
        }
    }

}