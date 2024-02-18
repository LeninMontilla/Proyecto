package com.example.proyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.proyecto.Model.DbManager

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val editUsuario = findViewById<EditText>(R.id.editTextDate7)
        val editContraseña = findViewById<EditText>(R.id.editTextNumber)
        val btnIngresar = findViewById<Button>(R.id.button3)
        val btnRegistrar = findViewById<Button>(R.id.button4)

        btnRegistrar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btnIngresar.setOnClickListener{
            val usuario = editUsuario.text.toString()
            val contraseña = editContraseña.text.toString()

            val managerDb = DbManager(this)
            val resul= managerDb.insertData(usuario, contraseña)

            if(resul>0){
                Toast.makeText(this, "DATOS INSERTADOS" + resul, Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this,"Problemas al insertar" + resul, Toast.LENGTH_SHORT).show()
            }
        }
    }
}