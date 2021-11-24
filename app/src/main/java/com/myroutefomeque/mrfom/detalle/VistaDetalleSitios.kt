package com.myroutefomeque.mrfom.detalle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.myroutefomeque.mrfom.R
import com.myroutefomeque.mrfom.databinding.ActivityVistaDetalleSitiosBinding
import com.myroutefomeque.mrfom.model.SitiosTuristicosItem

class VistaDetalleSitios : AppCompatActivity() {

    private lateinit var detalleBinding: ActivityVistaDetalleSitiosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detalleBinding = ActivityVistaDetalleSitiosBinding.inflate(layoutInflater)
        //La linea de arriba reemplaza esta //setContentView(R.layout.activity_vista_detalle_sitios)

        setContentView(detalleBinding.root)

        val sitiosturisticos : SitiosTuristicosItem = intent.extras?.getSerializable("sitiosturisticos") as SitiosTuristicosItem
        with(detalleBinding){
            nameTextView.text = sitiosturisticos.nombre
            temperatureTextView.text = sitiosturisticos.temperatura.toString()
            puntajeTextView.text = sitiosturisticos.puntuacion.toString()
            locationTextView.text = sitiosturisticos.ubicacion
            descriptionTextView.text = sitiosturisticos.infoGeneral
            sitioRecTextView.text = sitiosturisticos.sitiosRecomendados
        }
    }
}