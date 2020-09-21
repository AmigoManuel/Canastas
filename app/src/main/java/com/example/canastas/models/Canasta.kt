package com.example.canastas.models

import java.time.LocalDate
import java.time.LocalTime

// Canasta es una compra pendiente, completada o cancelada
data class Canasta(val nombre:String, val total:Int, val tienda:String, val descripcion:String, val fecha:LocalDate, val hora:LocalTime){
    var id = 0
    var estado = ""
}
