package com.example.canastas

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.canastas.db.DBHandler
import com.example.canastas.models.Canasta
import kotlinx.android.synthetic.main.fragment_pendientes.*
import java.time.LocalDate
import java.time.LocalTime

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

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
        // Manejo de clicks en item de la recyclerView
        recyclerViewPendientes.addOnItemClickListener(object: OnItemClickListener {
            override fun onItemClicked(position: Int, view: View) {

            }
        })
    }

    // Se ejecuta al volver dentro del fragment
    // se utiliza para actualizar luego de crear una canasta
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onResume() {
        super.onResume()
        setCanastasOnView()
    }

    // Interface para utilizar al clickear un item de la recyclerView
    interface OnItemClickListener {
        fun onItemClicked(position: Int, view: View)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun setCanastasOnView(){
        // Consulta por las canastas en la bd
        val db = DBHandler(requireContext())
        // Asigna la lista de canastas en el array local
        listaCanastas = db.db_get_canastasPendientes()
        // Setea las canastas de la bd dentro del recyclerView
        recyclerViewPendientes.adapter = CanastaAdapter(listaCanastas)
        recyclerViewPendientes.layoutManager = LinearLayoutManager(activity)
        recyclerViewPendientes.setHasFixedSize(true)
    }

    // ItemClickListener al presionar un item
    private fun RecyclerView.addOnItemClickListener(onClickListener: OnItemClickListener) {
        this.addOnChildAttachStateChangeListener(object: RecyclerView.OnChildAttachStateChangeListener {

            override fun onChildViewAttachedToWindow(view: View) {
                val holder = getChildViewHolder(view)
                onClickListener.onItemClicked(holder.adapterPosition, view)
            }

            override fun onChildViewDetachedFromWindow(view: View) {
                view.setOnClickListener(null)
            }
        })
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PendientesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}