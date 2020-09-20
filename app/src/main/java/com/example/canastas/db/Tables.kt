package com.example.canastas.db

// Tablas de la BD
class Tables {
    // abstract y companion para referenciar sin instanciar
    // similar a un static

    // tabla canasta
    abstract class Canasta {
        companion object{
            const val TABLE_NAME = "User"
            const val COL_ID = "id"
            const val COL_NOMBRE = "nombre"
            const val COL_TOTAL = "total"
            const val COL_TIENDA = "tienda"
            const val COL_DESCRIPCION = "descripcion"
            const val COL_FECHA = "fecha"
            const val COL_HORA = "hora"
        }
    }
    // tabla producto
    abstract class Producto {
        companion object{
            const val TABLE_NAME = "Producto"
            const val COL_ID = "id"
            const val COL_NOMBRE = "nombre"
            const val COL_VALOR = "valor"
            const val COL_CANTIDAD = "cantidad"
        }
    }
    // tabla para asociar producto a canasta
    abstract class ProductoEnCanasta {
        companion object{
            const val TABLE_NAME = "ProductoEnCanasta"
            const val COL_ID_CANASTA = "id_canasta"
            const val COL_ID_PRODUCTO = "id_producto"
        }
    }
}