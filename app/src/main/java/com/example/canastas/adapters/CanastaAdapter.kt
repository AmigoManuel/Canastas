package com.example.canastas.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.canastas.R
import com.example.canastas.models.Canasta
import kotlinx.android.synthetic.main.item_canasta.view.*

// CanastaAdapter se encarga de representar la información
// que contenga dentro de la RecyclerView
class CanastaAdapter(private val listCanasta : List<Canasta>, private val clickListener: (Canasta) -> Unit) : RecyclerView.Adapter<CanastaAdapter.CanastaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CanastaViewHolder {
        // Esta linea instancia la vista de los items dentro del layout
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_canasta, parent, false)
        return CanastaViewHolder(itemView)
    }

    // Esta función escribira sobre cada item los valores dentro de la listCanasta
    override fun onBindViewHolder(holder: CanastaViewHolder, position: Int) {
        // Por cada canasta se asignara un ViewHolder que determine que mostrar en el item
        holder.bind(listCanasta[position], clickListener)
    }

    override fun getItemCount(): Int {
        return listCanasta.size
    }

    // La subclase ViewHolder ayuda a identificar los elementos del item en la lista
    class CanastaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(canasta: Canasta, clickListener: (Canasta) -> Unit) {
            // Asigna los elementos de la canasta en el item de la lista
            itemView.nombre.text = canasta.nombre
            itemView.tienda.text = canasta.tienda
            itemView.total.text = canasta.total.toString()
            // Asigna el clickListener para manejar la interacción con ese item
            itemView.setOnClickListener{ clickListener(canasta) }
        }
    }
}