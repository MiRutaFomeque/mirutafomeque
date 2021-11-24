package com.myroutefomeque.mrfom.detalle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.myroutefomeque.mrfom.databinding.ActivityVistaDetalleSitiosBinding

class VistaDetalleSitios : AppCompatActivity() {

    private lateinit var detalleBinding: ActivityVistaDetalleSitiosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detalleBinding = ActivityVistaDetalleSitiosBinding.inflate(layoutInflater)
        //La linea de arriba reemplaza esta //setContentView(R.layout.activity_vista_detalle_sitios)

        val nombre = intent.extras?.getString("nombre")
        detalleBinding.nameTextView.text = nombre
    }
}