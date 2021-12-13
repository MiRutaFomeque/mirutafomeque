package com.myroutefomeque.mirutafomeque.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.myroutefomeque.mirutafomeque.R
import com.myroutefomeque.mirutafomeque.model.SitiosTuristicosItem
import com.squareup.picasso.Picasso

class SitiosturisticosAdapter(
    private val SitiosturisticosList: ArrayList<SitiosTuristicosItem>,
    private val onItemClicked: (SitiosTuristicosItem) -> Unit

    ) : RecyclerView.Adapter<SitiosturisticosAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_sitios_turisticos_item, parent, false)
        return  ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val SitiosTuristicos = SitiosturisticosList[position]
        holder.itemView.setOnClickListener { onItemClicked(SitiosturisticosList[position]) }
        holder.bind(SitiosTuristicos)
    }

    override fun getItemCount(): Int = SitiosturisticosList.size

    fun appendItems(newItems: ArrayList<SitiosTuristicosItem>) {
        SitiosturisticosList.clear()
        SitiosturisticosList.addAll(newItems)
        notifyDataSetChanged()
    }


    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        private var name_text_View: TextView = itemView.findViewById(R.id.name_text_View)
        private var location_text_View: TextView = itemView.findViewById(R.id.location_text_View)
        private var picture_image_View: ImageView = itemView.findViewById(R.id.picture_image_View)
        private var description_text_View: TextView = itemView.findViewById(R.id.description_text_View)
        private var temperature_text_View: TextView = itemView.findViewById(R.id.temperature_text_View)
        private var puntaje_text_View: TextView = itemView.findViewById(R.id.puntaje_text_View)

        fun bind(SitiosTuristicos: SitiosTuristicosItem){
            name_text_View.text = SitiosTuristicos.nombre
            location_text_View.text = SitiosTuristicos.ubicacion
            description_text_View.text = SitiosTuristicos.infoGeneral
            temperature_text_View.text = SitiosTuristicos.temperatura.toString()
            puntaje_text_View.text = SitiosTuristicos.puntuacion.toString()
            Picasso.get().load(SitiosTuristicos.urlPicture).into(picture_image_View);

        }
    }
}