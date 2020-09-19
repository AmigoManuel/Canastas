package com.example.canastas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Definimos el adapter para controlar viewpager con los tabs
        viewpager.adapter = PageAdapter(supportFragmentManager)
        // Liga el tabLayout con el viewpager
        tabLayout.setupWithViewPager(viewpager)
    }

    // TODO: Crear activiy para añadir nueva canasta
    fun nueva_canasta(view: View) {
        val t = Toast.makeText(applicationContext, "añadir nueva canasta", Toast.LENGTH_SHORT)
        t.show()
    }
}