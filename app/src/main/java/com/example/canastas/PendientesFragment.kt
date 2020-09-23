package com.example.canastas

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.canastas.db.DBHandler
import com.example.canastas.models.Canasta
import kotlinx.android.synthetic.main.fragment_pendientes.*

class PendientesFragment : Fragment() {

    // Lista de canastas pendientes manejadas por el fragment
    private var listaCanastas: ArrayList<Canasta> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pendientes, container, false)
    }

    // Se ejecuta al crear el fragment
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // Despliega las canastas pendientes dentro del fragment
        setCanastasOnView()
    }

    // Se ejecuta al volver dentro del fragment
    // se utiliza para actualizar luego de crear una canasta
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onResume() {
        super.onResume()
        setCanastasOnView()
    }

    // Función que se ejecuta al clickear un item de la lista
    private fun canastaItemClicked(canasta: Canasta) {
        Toast.makeText(requireContext(),"item ${canasta.nombre}",Toast.LENGTH_SHORT).show()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun setCanastasOnView(){
        // Consulta por las canastas en la bd
        val db = DBHandler(requireContext())
        // Asigna la lista de canastas en el array local
        listaCanastas = db.db_get_canastasPendientes()
        // Setea las canastas de la bd dentro del recyclerView
        //{ partItem : PartData -> partItemClicked(partItem) }
        recyclerViewPendientes.adapter = CanastaAdapter(listaCanastas) { canasta: Canasta -> canastaItemClicked(canasta) }
        recyclerViewPendientes.layoutManager = LinearLayoutManager(activity)
        recyclerViewPendientes.setHasFixedSize(true)
    }
}