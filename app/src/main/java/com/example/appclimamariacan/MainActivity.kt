package com.example.appclimamariacan

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var tvCiudad:TextView? = null
    var tvGrados:TextView? = null
    var tvEstatus:TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvCiudad = findViewById(R.id.tvCiudad)
        tvGrados= findViewById(R.id.tvGrados)
        tvEstatus = findViewById(R.id.tvEstatus)

        val ciudad = intent.getStringExtra("com.example.appclimamariacan.ciudades.CIUDAD")

        val ciudaddCan = Ciudad("Ciudad de Cancún", 23, "Nublado")
        val ciudaddFcp = Ciudad("Ciudad de Felipe Carrillo Puerto", 25, "Soleado")
        val ciudaddChe = Ciudad("Ciudad de Chetumal", 19, "Chubascos")
        val ciudaddBac = Ciudad("Ciudad de Bacalar", 15, "Lluvia")
        if(ciudad == "ciudad-cancun"){
            //mostar informacion ciudaddcan
            tvCiudad?.text = ciudaddCan.nombre
            tvGrados?.text = ciudaddCan.grados.toString() + "°"
            tvEstatus?.text = ciudaddCan.estatus
        }else if(ciudad == "ciudad-felipe carrillo puerto"){
            //mostrar información ciudaddFcp
            tvCiudad?.text = ciudaddFcp.nombre
            tvGrados?.text = ciudaddFcp.grados.toString() + "°"
            tvEstatus?.text = ciudaddFcp.estatus
        }else if(ciudad == "ciudad-chetumal"){
            //mostrar informacion ciudaddChe
            tvCiudad?.text = ciudaddChe.nombre
            tvGrados?.text = ciudaddChe.grados.toString() + "°"
            tvEstatus?.text = ciudaddChe.estatus
        }else if(ciudad == "ciudad-bacalar"){
            //mostrar información ciudaddBac
            tvCiudad?.text = ciudaddBac.nombre
            tvGrados?.text = ciudaddBac.grados.toString() + "°"
            tvEstatus?.text = ciudaddBac.estatus
        }else{
            Toast.makeText(this, "No se encuentra la información", Toast.LENGTH_SHORT).show()
        }
    }
}