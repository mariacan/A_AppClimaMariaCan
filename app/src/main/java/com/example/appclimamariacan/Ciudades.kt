package com.example.appclimamariacan

import android.content.Intent
import android.nfc.Tag
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class Ciudades : AppCompatActivity() {

    val TAG = "com.example.appclimamariacan.ciudades.CIUDAD"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ciudades)

        val bCancun = findViewById<Button>(R.id.bCancun)
        val bfcp = findViewById<Button>(R.id.bfcp)
        val bChetumal = findViewById<Button>(R.id.bChetumal)
        val bBacalar = findViewById<Button>(R.id.bBacalar)

        bCancun.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(TAG, "3531673")
            startActivity(intent)
        })
        bfcp.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(TAG, "3527639")
            startActivity(intent)
        })
        bChetumal.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(TAG, "3531023")
            startActivity(intent)
        })
        bBacalar.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(TAG, "3532465")
            startActivity(intent) //Al dar click al boton te mandará al MainActivity(Información de la ciudad).
        })
    }
}