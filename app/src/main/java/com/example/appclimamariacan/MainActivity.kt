package com.example.appclimamariacan

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson

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

        if(Network.hayRed(this)){
            //ejecutar solicitud HTTP
            solicitudHTTPVolley("https://api.openweathermap.org/data/2.5/weather?id="+ciudad+"&appid=de72b2851efe338c4ee4cee2a5385a03&units=metric&lang=es")
            //1254df0aa2abc6673823db9d920d4ae3
            //Cancún - 3531673,
        }else{
            //mostrar mensaje error
            Toast.makeText(this, "No hay RED", Toast.LENGTH_SHORT).show()
        }
    }
    //Método para Volley
    private fun solicitudHTTPVolley(url:String){
        val queue = Volley.newRequestQueue(this)

        val solicitud = StringRequest(Request.Method.GET, url, Response.Listener<String>{
                response ->
            try {
                Log.d("solicitudHTTPVolley", response)

                val  gson = Gson()
                val ciudad = gson.fromJson(response, Ciudad::class.java)
                tvCiudad?.text = ciudad.name
                tvGrados?.text = ciudad.main?.temp.toString() + "°"
                tvEstatus?.text = ciudad.weather?.get(0)?.description
            }catch (e: Exception){
                //
            }
        }, Response.ErrorListener {  })
        queue.add(solicitud)
    }
}