package com.example.registrasiloginforgetpassword

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var daftarTemanRecyclerView : RecyclerView
    private lateinit var listDaftarTeman: ArrayList<Data>

    private lateinit var foto: Array<Int>
    private lateinit var nama: Array<String>
    private lateinit var handphone: Array<String>
    private lateinit var alamat: Array<String>
    private lateinit var bio: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        return view
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialTeman()
        val layoutManager = LinearLayoutManager(context)
        daftarTemanRecyclerView = view.findViewById(R.id.daftarTeman)
        daftarTemanRecyclerView.layoutManager = layoutManager
        daftarTemanRecyclerView.setHasFixedSize(true)

        listDaftarTeman = arrayListOf<Data>()
        getDataUser()
    }

    private fun dataInitialTeman() {
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


    }

    private fun getDataUser() {
        val listDaftarTeman = ArrayList<Data>()
        for ( i in foto.indices) {
            val dataTeman = Data(foto[i],nama[i],handphone[i])
            listDaftarTeman.add(dataTeman)
        }

        val adapter = Adapter(listDaftarTeman)
        daftarTemanRecyclerView.adapter = adapter

        adapter.setOnItemClickListener(object: Adapter.onItemClickListener {
            override fun onItemClick(position: Int) {
                val intent = Intent(requireActivity(), DetailActivity::class.java)
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