package com.example.proyecto.Model

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

class DbManager(val context: Context) {

    lateinit var bd : SQLiteDatabase
    val bdHelper = DbHelper(context)

    fun openBdWr(){
        bd = bdHelper.writableDatabase
    }

    fun openDbRd(){
        bd = bdHelper.readableDatabase
    }

    fun insertData(nombre: String, apellido: String, telefono: String, cedula: String, contraseña: String, usuario: String): Long{
        openBdWr()

        val values = ContentValues()
        values.put("nombre", nombre)
        values.put("apellido", apellido)
        values.put("telefono", telefono)
        values.put("cedula", cedula)
        values.put("contraseña", contraseña)
        values.put("usuario", usuario)

        val result = bd.insert("datos", null, values)

        return result
    }

    fun insertData(usuario: String, contraseña: String):Long{
        //paso 1:  abrir base de datos en modo escritura
        openBdWr()
        //paso2: crear un contenedor de valores para ingresar los datos
        val values = ContentValues()
        values.put("usuario", usuario)
        values.put("contraseña", contraseña)
        val  resul = bd.insert("datos",null,values)
        return resul
    }

    fun listUsuarios():ArrayList<Usuario>{
        val usuarioList=ArrayList<Usuario>()
        openDbRd()
        val cursor: Cursor = bd.rawQuery("select * from usuario", null)
        if(cursor.moveToFirst()){
            do{
                val nombreIndex = cursor.getColumnIndex("nombre")
                val apellidoIndex = cursor.getColumnIndex("apellido")
                val telefonoIndex = cursor.getColumnIndex("telefono")
                val cedulaIndex = cursor.getColumnIndex("cedula")
                val contraseñaIndex = cursor.getColumnIndex("contraseña")
                val userIndex = cursor.getColumnIndex("user")

                val nombre = cursor.getString(nombreIndex)
                val apellido = cursor.getString(apellidoIndex)
                val telefono = cursor.getString(telefonoIndex)
                val cedula = cursor.getString(cedulaIndex)
                val contraseña = cursor.getString(contraseñaIndex)
                val user = cursor.getString(userIndex)

                val usuario = Usuario(nombre, apellido, telefono, cedula, contraseña, user)

                usuarioList.add(usuario)

            } while (cursor.moveToNext())
        }

        return usuarioList

    }

}