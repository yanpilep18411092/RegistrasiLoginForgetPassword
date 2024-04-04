package com.example.registrasiloginforgetpassword

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val gambar:ImageView = findViewById(R.id.iv_Foto)
        val nama:TextView = findViewById(R.id.tv_Nama)
        val handpone:TextView = findViewById(R.id.tv_NoHp)
        val alamat:TextView = findViewById(R.id.tv_Alamat)
        val bio:TextView = findViewById(R.id.tv_Bio)

        val bundle: Bundle? = intent.extras
        val bNama = bundle!!.getString("idnama")
        val bFoto = bundle.getInt("idfoto")
        val bHandphone = bundle.getString("idhandphone")
        val bAlamat = bundle.getString("idalamat")
        val bBio = bundle.getString("idbio")

        gambar.setImageResource(bFoto)
        nama.text = bNama
        handpone.text = bHandphone
        alamat.text = bAlamat
        bio.text = bBio


    }
}