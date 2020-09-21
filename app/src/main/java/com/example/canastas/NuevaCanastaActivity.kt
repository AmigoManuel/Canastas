package com.example.canastas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class NuevaCanastaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nueva_canasta)
    }

    fun cancelarNuevaCanasta(view: View) {
        // Cierra el activity actual
        finish()
    }
}