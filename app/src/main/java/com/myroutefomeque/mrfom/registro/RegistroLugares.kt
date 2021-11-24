package com.myroutefomeque.mrfom.registro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.myroutefomeque.mrfom.R

class RegistroLugares : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Método","onCreate")
        setContentView(R.layout.activity_registro_lugares)

        val agregarRegistro: Button = findViewById(R.id.agregar_registro)
        val nombreEditText: EditText = findViewById(R.id.nombre_edit_text)
        val visorDeTextoTextView: TextView = findViewById(R.id.visor_de_texto_text_view)

        agregarRegistro.setOnClickListener {
            val nombre : String = nombreEditText.text.toString()
            visorDeTextoTextView.text = nombre

        }

    }

    override fun onStart() {
        super.onStart()
        Log.d("Método","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Método","onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Método","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Método","onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Método","onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Método","onRestart")
    }
}