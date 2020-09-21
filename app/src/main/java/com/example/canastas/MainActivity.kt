package com.example.canastas

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.canastas.db.DBHandler
import com.example.canastas.models.Canasta
import kotlinx.android.synthetic.main.activity_main.*
import java.time.LocalDate
import java.time.LocalTime

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
    // TODO: Que cada fragment lea sus canastas
    @RequiresApi(Build.VERSION_CODES.O)
    fun nueva_canasta(view: View) {
        val canasta_1 = Canasta(
            "Compras super",
            12990,
            "Lider",
            "Compras del mes que debo hacer en el super",
            LocalDate.now(),
            LocalTime.now()
        )
        val db = DBHandler(applicationContext)
        db.db_nueva_canasta(canasta_1)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun canastasPendientes(){
        val db = DBHandler(applicationContext)
        val data = db.db_get_canastasPendientes()
        print(data)
    }
}