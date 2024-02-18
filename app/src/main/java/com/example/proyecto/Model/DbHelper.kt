package com.example.proyecto.Model

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DbHelper (
    context: Context?,
) : SQLiteOpenHelper(context, Constantes.NOM_BD, null, Constantes.VERSION_BD){
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(Constantes.TABLA)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
        db?.execSQL("DROP TABLE IF EXISTS datos")
        onCreate(db)

    }
}