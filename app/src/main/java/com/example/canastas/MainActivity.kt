package com.example.canastas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.canastas.adapters.PageAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Para identificarlo como variable y luego utilizarlo
        // realmente no es necesario
        //val viewpager = findViewById<ViewPager>(R.id.viewpager)

        // Definimos el adapter para controlar viewpager con los tabs
        viewpager.adapter = PageAdapter(supportFragmentManager)

        // Liga el tabLayout con el viewpager
        tabLayout.setupWithViewPager(viewpager)
    }

    // Botón flotante para añadir nueva canasta
    fun nuevaCanasta(view: View) {
        // Inicia nuevo activity para añadir canasta
        val intent = Intent(this, NuevaCanastaActivity::class.java)
        startActivity(intent)
    }
}