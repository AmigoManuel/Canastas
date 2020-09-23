package com.example.canastas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

// Activity para desplegar la canasta al ser seleccionada
// TODO: se debe identificar si la canasta es pendiente, cancelada o completada

class CanastaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_canasta)

        val canasta = intent.getStringExtra("obj_canasta")
    }
}