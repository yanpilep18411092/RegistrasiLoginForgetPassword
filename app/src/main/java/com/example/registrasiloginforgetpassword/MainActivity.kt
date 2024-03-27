package com.example.registrasiloginforgetpassword

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.registrasiloginforgetpassword.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //private lateinit var binding: ActivityMainBinding

    private lateinit var daftarTemanRecyclerView : RecyclerView
    private lateinit var daftarTemanAdapter: Adapter
    private lateinit var listDaftarTeman: ArrayList<Data>

    override fun onCreate(savedInstanceState: Bundle?) {
        //binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        //setContentView(binding.root)
        setContentView(R.layout.activity_main)

        daftarTemanRecyclerView = findViewById(R.id.daftarTeman)
        listDaftarTeman = ArrayList()

        listDaftarTeman.add(Data(R.drawable.t1, "Bapatua John", "081222347889"))
        listDaftarTeman.add(Data(R.drawable.t1, "Wellem Manuaron", "081222347889"))
        listDaftarTeman.add(Data(R.drawable.t1, "Soleman Merani", "081222347889"))
        listDaftarTeman.add(Data(R.drawable.t1, "Wellem Manuaron", "081222347889"))
        listDaftarTeman.add(Data(R.drawable.t1, "Soleman Merani", "081222347889"))
        listDaftarTeman.add(Data(R.drawable.t1, "Wellem Manuaron", "081222347889"))
        listDaftarTeman.add(Data(R.drawable.t1, "Soleman Merani", "081222347889"))
        listDaftarTeman.add(Data(R.drawable.t1, "Wellem Manuaron", "081222347889"))
        listDaftarTeman.add(Data(R.drawable.t1, "Soleman Merani", "081222347889"))
        listDaftarTeman.add(Data(R.drawable.t1, "Wellem Manuaron", "081222347889"))
        listDaftarTeman.add(Data(R.drawable.t1, "Soleman Merani", "081222347889"))
        listDaftarTeman.add(Data(R.drawable.t1, "Wellem Manuaron", "081222347889"))
        listDaftarTeman.add(Data(R.drawable.t1, "Soleman Merani", "081222347889"))


        daftarTemanRecyclerView.layoutManager = LinearLayoutManager(this)
        daftarTemanRecyclerView.setHasFixedSize(true)
        daftarTemanAdapter = Adapter(listDaftarTeman)
        daftarTemanRecyclerView.adapter = daftarTemanAdapter

    }

}