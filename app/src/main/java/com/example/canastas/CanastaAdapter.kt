package com.example.canastas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.canastas.models.Canasta
import kotlinx.android.synthetic.main.item_canasta.view.*

// CanastaAdapter se encarga de representar la información
// que contenga dentro de la RecyclerView
class CanastaAdapter(private val listCanasta : List<Canasta>) : RecyclerView.Adapter<CanastaAdapter.CanastaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CanastaViewHolder {
        // Esta linea instancia la vista de los items dentro del layout
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_canasta, parent, false)
        return CanastaViewHolder(itemView)
    }

    // Esta función escribira sobre cada item los valores dentro de la listCanasta
    override fun onBindViewHolder(holder: CanastaViewHolder, position: Int) {
        val currentItem = listCanasta[position]
        holder.textViewNombre.text = currentItem.nombre
        holder.textViewTienda.text = currentItem.tienda
        holder.textViewTotal.text = "$${currentItem.total}"
    }

    override fun getItemCount(): Int {
        return listCanasta.size
    }

    // La subclase ViewHolder ayuda a identificar los elementos del item en la lista
    class CanastaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewNombre: TextView = itemView.nombre
        val textViewTienda: TextView = itemView.tienda
        val textViewTotal: TextView = itemView.total
    }
}
/*
class CanastaAdapter(private val mContext:Context, private val listaCanastas:List<Canasta>) : ArrayAdapter<Canasta>(mContext, 0, listaCanastas) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Identificamos el layout de la canasta
        val layout = LayoutInflater.from(mContext).inflate(R.layout.item_canasta, parent,false)
        // Identificamos la canasta
        val canasta = listaCanastas[position]
        // Sobreescribimos el layout con la info de canasta
        layout.nombre.text = canasta.nombre
        layout.total.text = "$${canasta.total}"
        layout.tienda.text = canasta.tienda
        // TODO: Se debe parsear antes de escribir
        //layout.fecha_hora.text = canasta.fecha
        return layout
    }
}*/