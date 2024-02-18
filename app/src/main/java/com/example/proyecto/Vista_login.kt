package com.example.proyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import com.example.proyecto.Model.DbManager

class Vista_login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vista_login)

        val listDataUsuarios = findViewById<ListView>(R.id.listUsuarios)
        val dbManager = DbManager(this)
        val dataUsuarios =dbManager.listUsuarios()
        val adapterUsuarios = ArrayAdapter(this, android.R.layout.simple_list_item_1, dataUsuarios)
        listDataUsuarios.adapter = adapterUsuarios


        val btninicio = findViewById<Button>(R.id.btnInicio)

        btninicio.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}