package com.example.canastas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.canastas.models.Canasta
import kotlinx.android.synthetic.main.activity_canasta.*

// Activity para desplegar la canasta al ser seleccionada

class CanastaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_canasta)

        val canasta = intent.getSerializableExtra("obj_canasta") as Canasta
        nombre_canasta.text = canasta.nombre
        descripcion_canasta.text = canasta.descripcion
    }

    // Botón flotante para añadir nueva producto
    fun nuevoProducto(view: View) {
        Toast.makeText(this, "añadir producto", Toast.LENGTH_SHORT).show()
    }
}