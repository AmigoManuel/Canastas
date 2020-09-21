package com.example.canastas

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.canastas.db.DBHandler
import com.example.canastas.models.Canasta
import kotlinx.android.synthetic.main.activity_nueva_canasta.*
import java.time.LocalDate
import java.time.LocalTime

class NuevaCanastaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nueva_canasta)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun aceptarNuevaCanasta(view: View) {
        // Si los editText se encuentran con texto
        // insertar datos en bd
        if (editTextNombreCanasta.text.isNotEmpty() &&
            editTextTiendaCanasta.text.isNotEmpty() &&
            editTextDescripcionCanasta.text.isNotEmpty()) {

            val nombreCanasta = editTextNombreCanasta.text.toString()
            val tiendaCanasta = editTextTiendaCanasta.text.toString()
            val descripcionCanasta = editTextDescripcionCanasta.text.toString()

            val canasta = Canasta(
                nombreCanasta,
                0,
                tiendaCanasta,
                descripcionCanasta,
                LocalDate.now(),
                LocalTime.now()
            )

            val db = DBHandler(applicationContext)
            if (db.db_nueva_canasta(canasta)){
                Toast.makeText(applicationContext, "Nueva Canasta agregada", Toast.LENGTH_SHORT).show()
                finish()
            }else{
                Toast.makeText(applicationContext, "Error al agregar Canasta", Toast.LENGTH_SHORT).show()
            }
        }else{
            Toast.makeText(applicationContext,"Complete los datos para continuar", Toast.LENGTH_SHORT).show()
        }
    }

    fun cancelarNuevaCanasta(view: View) {
        // Cierra el activity actual
        finish()
    }
}