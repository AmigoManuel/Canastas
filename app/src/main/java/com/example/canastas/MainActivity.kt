package com.example.canastas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Definimos el adapter para controlar viewpager con los tabs
        viewpager.adapter = PageController(supportFragmentManager)
        // Liga el tabLayout con el viewpager
        tabLayout.setupWithViewPager(viewpager)
    }
}