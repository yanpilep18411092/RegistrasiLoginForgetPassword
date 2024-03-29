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

        listDaftarTeman.add(Data(R.drawable.t1, "Matatias Merani", "081222347889"))
        listDaftarTeman.add(Data(R.drawable.abet, "Abet Nego Nauw", "081222347889"))
        listDaftarTeman.add(Data(R.drawable.aris, "Aristoteles Rumaikewi", "081222347889"))
        listDaftarTeman.add(Data(R.drawable.magda, "Magdalena Isis", "081222347889"))
        listDaftarTeman.add(Data(R.drawable.russell, "Russell Herdian Que", "081222347889"))
        listDaftarTeman.add(Data(R.drawable.dian, "Diana Florice Iklai", "081222347889"))
        listDaftarTeman.add(Data(R.drawable.bewax, "Berto Wato", "081222347889"))
        listDaftarTeman.add(Data(R.drawable.marnix, "Daniel Marnix Akwan", "081222347889"))
        listDaftarTeman.add(Data(R.drawable.avinex, "Aviana X C Ibo", "081222347889"))
        listDaftarTeman.add(Data(R.drawable.marshal, "Marshal Yonatan", "081222347889"))
        listDaftarTeman.add(Data(R.drawable.keren, "Keren Marini", "081222347889"))
        listDaftarTeman.add(Data(R.drawable.kern, "Kern Bindosano", "081222347889"))
        listDaftarTeman.add(Data(R.drawable.frans, "Fransiskus Jeujanan", "081222347889"))
        listDaftarTeman.add(Data(R.drawable.dancok, "Daniel Srau", "081222347889"))
        listDaftarTeman.add(Data(R.drawable.bung_gep, "Gabriel Marini", "081222347889"))
        listDaftarTeman.add(Data(R.drawable.elly, "Elly Ansek", "081222347889"))
        listDaftarTeman.add(Data(R.drawable.imanuel, "Imanuel Merani", "081222347889"))
        listDaftarTeman.add(Data(R.drawable.jodi, "Jodi Mamoribo", "081222347889"))
        listDaftarTeman.add(Data(R.drawable.kasis, "Rebekha Siska Genongga", "081222347889"))
        listDaftarTeman.add(Data(R.drawable.rico, "Rico Naa", "081222347889"))
        listDaftarTeman.add(Data(R.drawable.will, "Wellem Manuaron", "081222347889"))
        listDaftarTeman.add(Data(R.drawable.natan, "Nataniel Pakibori", "081222347889"))
        listDaftarTeman.add(Data(R.drawable.yonat, "Yonatan Airei", "081222347889"))
        listDaftarTeman.add(Data(R.drawable.icko, "Ikolaus Uropmabin", "081222347889"))
        listDaftarTeman.add(Data(R.drawable.mas, "Mas Kogoya", "081222347889"))


        daftarTemanRecyclerView.layoutManager = LinearLayoutManager(this)
        daftarTemanRecyclerView.setHasFixedSize(true)
        daftarTemanAdapter = Adapter(listDaftarTeman)
        daftarTemanRecyclerView.adapter = daftarTemanAdapter

    }

}