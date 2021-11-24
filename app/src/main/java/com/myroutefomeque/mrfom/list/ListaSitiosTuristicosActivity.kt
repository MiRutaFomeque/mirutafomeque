package com.myroutefomeque.mrfom.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.myroutefomeque.mrfom.R
import com.myroutefomeque.mrfom.model.SitiosTuristicos
import com.myroutefomeque.mrfom.model.SitiosTuristicosItem
import kotlin.math.log

class ListaSitiosTuristicosActivity : AppCompatActivity() {

    private lateinit var listSitios: ArrayList<SitiosTuristicosItem>
    private lateinit var sitiosTuristicosAdapter: SitiosturisticosAdapter
    private lateinit var sitiosrecyclerview: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_sitios_turisticos)

        sitiosrecyclerview = findViewById(R.id.lista_sitios_recycler_view)
        //listSitios = crearMockListaSitios()
        listSitios = loadMockListaSitiosFromJson()
        sitiosTuristicosAdapter = SitiosturisticosAdapter(listSitios, onItemClicked = { onSitiosTuristicosClicked(it) })

        /*sitiosrecyclerview.addItemDecoration(
            DividerItemDecoration(
                this, DividerItemDecoration.VERTICAL
            )
        )*/

        sitiosrecyclerview.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = sitiosTuristicosAdapter
            setHasFixedSize(false)
        }


    }

    private fun onSitiosTuristicosClicked(sitiosturisticos: SitiosTuristicosItem) {
        Log.d("ubicacion", sitiosturisticos.ubicacion)
    }

    private fun loadMockListaSitiosFromJson(): ArrayList<SitiosTuristicosItem> {

        var listaSitiosTurString : String = applicationContext.assets.open("sitiosTuristicos.json").bufferedReader().use { it.readText() }
        val gson = Gson()
        val data = gson.fromJson(listaSitiosTurString, SitiosTuristicos::class.java)
        return data
    }

/*
    private fun crearMockListaSitios() : ArrayList<SitiosTuristicos>{
        return arrayListOf(
            SitiosTuristicos(
                nombre = "La Cumbre",
                infoGeneral = "Destinada a producción de truchas, cuenta con una capacidad para unas 45.000 truchas las cuales se venden al turista y a los negocios\ndel oriente de Cundinamarca así como en la\nciudad de Bogotá",
                ubicacion = "En la vereda de Chinia",
                temperatura = 18,
                sitiosRecomendados = "El mismo lugar",
                puntuacion = 100,
                urlPicture = "https://jhostore.store/wp-content/uploads/2021/11/LaCumbre.jpg"
            ),
            SitiosTuristicos(
                nombre = "La Unión",
                infoGeneral = "El asentamiento inicial de Fómeque se realiza sobre lo que hoy se conoce como la Unión, sin embargo se traslado a un valle de mayor elevacion que permite apreciar los territorios de Choachi y Ubaque. La Unión tiene un clima calido y una población relativamente pequeña, pero cuenta con una cantidad de atractivos que invitan al turista a conocer la riqueza ambiental del municipio y sus\npotencialidades como proveedor de turismo de\nnaturaleza y aventura.",
                ubicacion = "Al suroeste de Ucuatoque.",
                temperatura = 22,
                sitiosRecomendados = "La capilla,las playas,balneario,Restaurante Casa Betelu,",
                puntuacion = 200,
                urlPicture = "https://jhostore.store/wp-content/uploads/2021/11/LaUnion.jpg"
            ),
            SitiosTuristicos(
                nombre = "Chingaza",
                infoGeneral = "Esta es considerada una de las reservas ecológicasmás importantes del mundo, albergando una\nvariedad importante de especies vegetales.Entre éstas se\nencuentran ocho especies de musgo de pantano,\nconsideradas maravillas ecológicas por la conservación\nde la humedad ambiental ya que pueden\nabsorber hasta 40 veces su peso en agua liberándola\ngradualmente a las fuentes hidricas.",
                ubicacion = "En la Cordillera Oriental, en la región andina.",
                temperatura = 21,
                sitiosRecomendados = "Laguna de Siecha,sendero Lagunas de Buitrago, sendero Cuchillas de Siecha, sendero Laguna Seca, sendero Suasie Corto y Suasie Largo y el sendero las Plantas del Camino.",
                puntuacion = 300,
                urlPicture = "https://jhostore.store/wp-content/uploads/2021/11/Chingaza.jpg"
            ),
            SitiosTuristicos(
                nombre = "Parque Jesús Maestro",
                infoGeneral = "El parque Jesús Maestro fue reconstruido entre 1988 y el año 2000, donde se acondiciono como\\nse encuentra en la actualidad, con variedad de\\nplantas y árboles conservando el verde de la naturaleza,\\ncuenta con una estatua en el centro y\\nsillas de cemento donde se reúnen propios y extraños\\ndiariamente para dialogar, tomar un café o\\npasar un rato, es un punto de encuentro importante",
                ubicacion = "Carrera 3ª, Fómeque, Cundinamarca, Colombia",
                temperatura = 18,
                sitiosRecomendados = "Parque San Isidro,Iglesia Inmaculada Concepcion,hoteles,Colegio Monseñor Agustin Gutierrez,Alto de las tres cruces Ect.",
                puntuacion = 400,
                urlPicture = "https://jhostore.store/wp-content/uploads/2021/11/ParqueJesusMaestro.jpg"
            ),
            SitiosTuristicos(
                nombre = "La casa de Fo ezama",
                infoGeneral = "Ezuama Muisca de la parcialidad de Fómeque. Cabildo Muisca Oriente",
                ubicacion = "Al nororiente de fomeque muy cerca al rio negro",
                temperatura = 12,
                sitiosRecomendados = "Rio negro",
                puntuacion = 500,
                urlPicture = "https://jhostore.store/wp-content/uploads/2021/11/LaCasaDeFoEzama.jpg"
            )
        )
    }*/



}