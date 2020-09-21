package com.example.canastas.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.canastas.models.Canasta
import java.time.LocalDate
import java.time.LocalTime

var DATABASE_NAME = "canastaDB"

class DBHandler(private var context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {
    // Al momento de crear la BD se ejecuta esta función
    override fun onCreate(db: SQLiteDatabase?) {
        val createTableCanasta = "CREATE TABLE ${Tables.Canasta.TABLE_NAME} (" +
                "${Tables.Canasta.COL_ID} INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "${Tables.Canasta.COL_NOMBRE} TEXT, " +
                "${Tables.Canasta.COL_TOTAL} INTEGER, " +
                "${Tables.Canasta.COL_TIENDA} TEXT, " +
                "${Tables.Canasta.COL_DESCRIPCION} TEXT, " +
                //"${Tables.Canasta.COL_FECHA} , " +
                //"${Tables.Canasta.COL_HORA} , " +
                "${Tables.Canasta.COL_ESTADO} TEXT);"
        val createTableProducto = "CREATE TABLE ${Tables.Producto.TABLE_NAME} (" +
                "${Tables.Producto.COL_ID} INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "${Tables.Producto.COL_NOMBRE} TEXT, " +
                "${Tables.Producto.COL_VALOR} INTEGER, " +
                "${Tables.Producto.COL_CANTIDAD} TEXT);"
        val createTableProductoEnCanasta = "CREATE TABLE ${Tables.ProductoEnCanasta.TABLE_NAME} (" +
                "${Tables.ProductoEnCanasta.COL_ID} INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "${Tables.ProductoEnCanasta.COL_ID_CANASTA} INTEGER, " +
                "${Tables.ProductoEnCanasta.COL_ID_PRODUCTO} INTEGER);"

        if (db!=null){
            db.execSQL(createTableCanasta)
            db.execSQL(createTableProducto)
            db.execSQL(createTableProductoEnCanasta)
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    // Función para retornar todas mis canastas
    @RequiresApi(Build.VERSION_CODES.O)
    fun db_get_canastasPendientes() : ArrayList<Canasta> {
        var listCanastas : ArrayList<Canasta> = ArrayList()
        val db = this.readableDatabase
        val query = "SELECT * FROM ${Tables.Canasta.TABLE_NAME} WHERE estado = 'pendiente';"
        val result = db.rawQuery(query,null)
        if (result.moveToFirst()) {
            do {
                val canasta = Canasta(
                    result.getString(result.getColumnIndex(Tables.Canasta.COL_NOMBRE)),
                    result.getString(result.getColumnIndex(Tables.Canasta.COL_TOTAL)).toInt(),
                    result.getString(result.getColumnIndex(Tables.Canasta.COL_TIENDA)),
                    result.getString(result.getColumnIndex(Tables.Canasta.COL_DESCRIPCION)),
                    LocalDate.now(),
                    LocalTime.now()
                )
                canasta.id = result.getString(result.getColumnIndex(Tables.Canasta.COL_ID)).toInt()
                listCanastas.add(canasta)
            } while (result.moveToNext())
        }
        result.close()
        db.close()
        return listCanastas
    }

    fun db_nueva_canasta(canasta : Canasta) : Boolean {
        val db = this.readableDatabase
        val cv = ContentValues()
        cv.put(Tables.Canasta.COL_NOMBRE, canasta.nombre)
        cv.put(Tables.Canasta.COL_TOTAL, canasta.total)
        cv.put(Tables.Canasta.COL_TIENDA, canasta.tienda)
        cv.put(Tables.Canasta.COL_DESCRIPCION, canasta.descripcion)
        cv.put(Tables.Canasta.COL_ESTADO, "pendiente")
        val res = db.insert(Tables.Canasta.TABLE_NAME, null, cv)
        return res != (-1).toLong()
    }
}