package com.example.proyecto

import com.example.proyecto.Model.DbManager
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editNombre = findViewById<EditText>(R.id.editTextDate)
        val editApellido = findViewById<EditText>(R.id.editTextDate2)
        val editTelefono = findViewById<EditText>(R.id.editTextDate3)
        val editCedula = findViewById<EditText>(R.id.editTextDate4)
        val editContraseña = findViewById<EditText>(R.id.editTextDate5)
        val editUsuario = findViewById<EditText>(R.id.editTextDate6)
        val btnRegistrar = findViewById<Button>(R.id.button)
        val btnMostrar = findViewById<Button>(R.id.button2)

        btnMostrar.setOnClickListener{
            val intent = Intent(this,Vista_login::class.java)
            startActivity(intent)
        }

        btnRegistrar.setOnClickListener{
            val Nombre = editNombre.text.toString()
            val Apellido = editApellido.text.toString()
            val Telefono = editTelefono.text.toString()
            val Cedula = editCedula.text.toString()
            val Contraseña = editContraseña.text.toString()
            val Usuario = editUsuario.text.toString()

            val managerDb = DbManager(this)
            val resul= managerDb.insertData(Nombre, Apellido, Telefono, Cedula, Contraseña, Usuario)

            if(resul>0){
                Toast.makeText(this, "DATOS INSERTADOS CORRECTAMENTE" + resul, Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this,"Problemas al insertar los datos" + resul, Toast.LENGTH_SHORT).show()
            }
        }
    }
}