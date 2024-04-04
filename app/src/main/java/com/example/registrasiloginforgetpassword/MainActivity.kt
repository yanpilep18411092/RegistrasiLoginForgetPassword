package com.example.registrasiloginforgetpassword

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.registrasiloginforgetpassword.databinding.ActivityMainBinding
import java.util.Objects

class MainActivity : AppCompatActivity() {

    //private lateinit var binding: ActivityMainBinding

    private lateinit var daftarTemanRecyclerView : RecyclerView
    // private lateinit var daftarTemanAdapter: Adapter
    private lateinit var listDaftarTeman: ArrayList<Data>
    private lateinit var foto: Array<Int>
    private lateinit var nama: Array<String>
    private lateinit var handphone: Array<String>
    private lateinit var alamat: Array<String>
    private lateinit var bio: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        //binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        //setContentView(binding.root)
        setContentView(R.layout.activity_main)


//        listDaftarTeman = ArrayList()
//        listDaftarTeman.add(Data(R.drawable.t1, "Matatias Merani", "081222347889"))
//        listDaftarTeman.add(Data(R.drawable.abet, "Abet Nego Nauw", "081222347889"))
//        listDaftarTeman.add(Data(R.drawable.aris, "Aristoteles Rumaikewi", "081222347889"))
//        listDaftarTeman.add(Data(R.drawable.magda, "Magdalena Isis", "081222347889"))
//        listDaftarTeman.add(Data(R.drawable.russell, "Russell Herdian Que", "081222347889"))
//        listDaftarTeman.add(Data(R.drawable.dian, "Diana Florice Iklai", "081222347889"))
//        listDaftarTeman.add(Data(R.drawable.bewax, "Berto Wato", "081222347889"))
//        listDaftarTeman.add(Data(R.drawable.marnix, "Daniel Marnix Akwan", "081222347889"))
//        listDaftarTeman.add(Data(R.drawable.avinex, "Aviana X C Ibo", "081222347889"))
//        listDaftarTeman.add(Data(R.drawable.marshal, "Marshal Yonatan", "081222347889"))
//        listDaftarTeman.add(Data(R.drawable.keren, "Keren Marini", "081222347889"))
//        listDaftarTeman.add(Data(R.drawable.kern, "Kern Bindosano", "081222347889"))
//        listDaftarTeman.add(Data(R.drawable.frans, "Fransiskus Jeujanan", "081222347889"))
//        listDaftarTeman.add(Data(R.drawable.dancok, "Daniel Srau", "081222347889"))
//        listDaftarTeman.add(Data(R.drawable.bung_gep, "Gabriel Marini", "081222347889"))
//        listDaftarTeman.add(Data(R.drawable.elly, "Elly Ansek", "081222347889"))
//        listDaftarTeman.add(Data(R.drawable.imanuel, "Imanuel Merani", "081222347889"))
//        listDaftarTeman.add(Data(R.drawable.jodi, "Jodi Mamoribo", "081222347889"))
//        listDaftarTeman.add(Data(R.drawable.kasis, "Rebekha Siska Genongga", "081222347889"))
//        listDaftarTeman.add(Data(R.drawable.rico, "Rico Naa", "081222347889"))
//        listDaftarTeman.add(Data(R.drawable.will, "Wellem Manuaron", "081222347889"))
//        listDaftarTeman.add(Data(R.drawable.natan, "Nataniel Pakibori", "081222347889"))
//        listDaftarTeman.add(Data(R.drawable.yonat, "Yonatan Airei", "081222347889"))
//        listDaftarTeman.add(Data(R.drawable.icko, "Ikolaus Uropmabin", "081222347889"))
//        listDaftarTeman.add(Data(R.drawable.mas, "Mas Kogoya", "081222347889"))


        foto = arrayOf(
            R.drawable.t1,
            R.drawable.abet,
            R.drawable.aris,
            R.drawable.magda,
            R.drawable.russell,
            R.drawable.dian,
            R.drawable.bewax,
            R.drawable.marnix,
            R.drawable.avinex,
            R.drawable.marshal,
            R.drawable.keren,
            R.drawable.kern,
            R.drawable.frans,
            R.drawable.dancok,
            R.drawable.bung_gep,
            R.drawable.elly,
            R.drawable.imanuel,
            R.drawable.jodi,
            R.drawable.kasis,
            R.drawable.rico,
            R.drawable.will,
            R.drawable.natan,
            R.drawable.yonat,
            R.drawable.icko,
            R.drawable.mas
        )

        nama = arrayOf(
            "Matatias", "Abed","Aristoteles", "Magdalena", "Russell",
            "Florince", "Berto Wato", "Marnix Akwan", "Aviana X C Ibo", "Marshal Yonatan",
            "Kerenhapukh", "Kern Bindosano", "Fransiskus Jeujanan", "Daniel Srau", "Gabriel Marini",
            "Elly Ansek", "Imanuel Merani", "Jodi Mamoribo", "Rebekha Siska", "Rico Naa",
            "Wellem Manuaron", "Nataniel pakibori", "Yonatan Airei", "Ickolaus Uropmabin",
            "Mas Kogoya"
        )

        handphone = arrayOf(
            "085211111111", "085222222222", "085233333333", "085244444444", "085255555555",
            "081200000000", "081299999999", "081288888888", "081277777777", "081266666666",
            "081333445566", "081344556677", "081355667788", "081366778899", "081377889900",
            "085211223344", "085222334455", "085233445566", "085244556677", "085255667890",
            "085211223344", "085222334455", "085233445566", "085244556677", "085255667890",
            "081234567890"
        )

        bio = arrayOf(
            getString(R.string.tias),
            getString(R.string.abed),
            getString(R.string.tias),
            getString(R.string.magda),
            getString(R.string.tias),
            getString(R.string.tias),
            getString(R.string.tias),
            getString(R.string.tias),
            getString(R.string.tias),
            getString(R.string.tias),
            getString(R.string.tias),
            getString(R.string.tias),
            getString(R.string.tias),
            getString(R.string.tias),
            getString(R.string.gep),
            getString(R.string.tias),
            getString(R.string.tias),
            getString(R.string.tias),
            getString(R.string.tias),
            getString(R.string.tias),
            getString(R.string.tias),
            getString(R.string.tias),
            getString(R.string.tias),
            getString(R.string.tias),
            getString(R.string.tias)
        )

        alamat = arrayOf(
            getString(R.string.tias_almt),
            getString(R.string.abed_almt),
            getString(R.string.tias_almt),
            getString(R.string.magda_almt),
            getString(R.string.tias_almt),
            getString(R.string.tias_almt),
            getString(R.string.tias_almt),
            getString(R.string.tias_almt),
            getString(R.string.tias_almt),
            getString(R.string.tias_almt),
            getString(R.string.tias_almt),
            getString(R.string.tias_almt),
            getString(R.string.tias_almt),
            getString(R.string.tias_almt),
            getString(R.string.gep_almt),
            getString(R.string.tias_almt),
            getString(R.string.tias_almt),
            getString(R.string.tias_almt),
            getString(R.string.tias_almt),
            getString(R.string.tias_almt),
            getString(R.string.tias_almt),
            getString(R.string.tias_almt),
            getString(R.string.tias_almt),
            getString(R.string.tias_almt),
            getString(R.string.tias_almt)
        )


        daftarTemanRecyclerView = findViewById(R.id.daftarTeman)
        daftarTemanRecyclerView.layoutManager = LinearLayoutManager(this)
        daftarTemanRecyclerView.setHasFixedSize(true)
        //daftarTemanAdapter = Adapter(listDaftarTeman)
        //daftarTemanRecyclerView.adapter = daftarTemanAdapter

        listDaftarTeman = arrayListOf<Data>()
        getDataUser()

    }

    private fun getDataUser() {
        for ( i in foto.indices) {
            val dataTeman = Data(foto[i],nama[i],handphone[i])
            listDaftarTeman.add(dataTeman)
        }

        var adapter = Adapter(listDaftarTeman)
        daftarTemanRecyclerView.adapter = adapter

        adapter.setOnItemClickListener(object: Adapter.onItemClickListener {
            override fun onItemClick(position: Int) {
                intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra("idfoto", listDaftarTeman[position].foto)
                intent.putExtra("idnama", listDaftarTeman[position].nama)
                intent.putExtra("idhandphone", listDaftarTeman[position].handphone)
                intent.putExtra("idalamat", alamat[position])
                intent.putExtra("idbio", bio[position])

                startActivity(intent)
            }
        })
    }



}