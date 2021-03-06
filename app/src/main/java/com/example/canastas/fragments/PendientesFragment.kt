package com.example.canastas.fragments

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.canastas.CanastaActivity
import com.example.canastas.R
import com.example.canastas.adapters.CanastaAdapter
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
        // Intent nos llevara a una nueva Activity
        // debemos entregarle un context, la activity y si queremos entregarle datos
        // añadimos un putExtra con el metodo apply
        val intent = Intent(context, CanastaActivity::class.java).apply {
            putExtra("obj_canasta", canasta)
        }
        startActivity(intent)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun setCanastasOnView(){
        // Consulta por las canastas en la bd
        val db = DBHandler(requireContext())
        // Asigna la lista de canastas en el array local
        listaCanastas = db.db_get_canastasPendientes()
        // Setea las canastas de la bd dentro del recyclerView
        recyclerViewPendientes.adapter = CanastaAdapter(listaCanastas) { canasta: Canasta -> canastaItemClicked(canasta) }
        recyclerViewPendientes.layoutManager = LinearLayoutManager(activity)
        recyclerViewPendientes.setHasFixedSize(true)
    }
}