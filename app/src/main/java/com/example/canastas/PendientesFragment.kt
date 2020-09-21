package com.example.canastas

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.canastas.db.DBHandler
import com.example.canastas.models.Canasta
import kotlinx.android.synthetic.main.fragment_pendientes.*
import java.time.LocalDate
import java.time.LocalTime

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PendientesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PendientesFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pendientes, container, false)
    }

    // Se ejecuta al crear el fragment
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setCanastasOnView()
    }

    // Se ejecuta al volver dentro del fragment
    // se utiliza para actualizar luego de crear una canasta
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onResume() {
        super.onResume()
        setCanastasOnView()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun setCanastasOnView(){
        val db = DBHandler(requireContext())
        val listaCanastas = db.db_get_canastasPendientes()
        println(listaCanastas)
        // Prueba de listview
        //val canasta_1 = Canasta("Compras super",12990, "Lider", "Compras del mes que debo hacer en el super", LocalDate.now(), LocalTime.now())
        //        val canasta_2 = Canasta("Compras ropa",34600, "Falabella", "Comprar ropa en falabella", LocalDate.now(), LocalTime.now())
        //        val listaCanastas = listOf(canasta_1, canasta_2)
        recyclerViewPendientes.adapter = CanastaAdapter(listaCanastas)
        recyclerViewPendientes.layoutManager = LinearLayoutManager(activity)
        recyclerViewPendientes.setHasFixedSize(true)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PendientesFragment.
         */
        // TODO: Rename and change types and number of parameters
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