package com.example.registrasiloginforgetpassword

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.registrasiloginforgetpassword.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val intss = intent
        val nameT = intss.getStringExtra("NAMET")
        val nomorhpT = intss.getStringExtra("NOMORHPT")
        val descT = intss.getStringExtra("DESCT")
        val imgT = intss.getStringExtra("IMGT")

        binding.tvNama.text = nameT
        binding.tvNoHp.text = nomorhpT
        binding.tvBio.text = descT
        binding.ivFoto.loadImage(imgT)



    }
}