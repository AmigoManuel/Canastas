package com.example.canastas

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

// PageController se encarga de gestionar que fragment mostrar
class PageController(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    // Cantidad de tabs
    override fun getCount(): Int {
        return 3
    }

    // Recibe como parametro el valor posicional en el tab
    // y ejecuta un nuevo fragment al cambiar el tab
    override fun getItem(position: Int): Fragment {
        // When es un switch
        return when (position) {
            0 -> {
                CompletadasFragment()
            }
            1 -> {
                PendientesFragment()
            }
            2 -> {
                CanceladasFragment()
            }
            else -> {
                CompletadasFragment()
            }
        }
    }

    // Retorna el titulo del tab
    // Se necesita para que no salga en blanco al ejecutar
    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> {
                "Pendientes"
            }
            1 -> {
                "Completadas"
            }
            2 -> {
                "Canceladas"
            }
            else -> {
                "Pendientes"
            }
        }
    }

}