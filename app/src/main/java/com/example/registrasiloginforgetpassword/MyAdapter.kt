package com.example.registrasiloginforgetpassword

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(var mContext: Context, var temanList: List<ImgData>) :
    RecyclerView.Adapter<MyAdapter.ListViewHolder>()
    {
        inner class ListViewHolder(var v : View) : RecyclerView.ViewHolder(v) {
            val imgT = v.findViewById<ImageView>(R.id.id_Foto)
            val nameT = v.findViewById<TextView>(R.id.id_Nama)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
            var inflater = LayoutInflater.from(parent.context)
            var v = inflater.inflate(R.layout.example_item,parent,false)
            return ListViewHolder(v)
        }

        override fun getItemCount(): Int {
            return temanList.size
        }

        override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
            var newList = temanList[position]
            holder.nameT.text = newList.name
            holder.imgT.loadImage(newList.fotoUrl)
            holder.v.setOnClickListener {

                val name = newList.name
                val nomorhp = newList.nomorhp
                val alamat = newList.alamat
                val fotoUri = newList.fotoUrl
                val deskripsi = newList.desc

                val mIntent = Intent(mContext, DetailActivity::class.java)
                mIntent.putExtra("NAMET", name)
                mIntent.putExtra("IMGT", fotoUri)
                mIntent.putExtra("NOMORHPT", nomorhp)
                mIntent.putExtra("DESCT", deskripsi)
                mIntent.putExtra("ALMTT", alamat)
                mContext.startActivity(mIntent)
            }
        }

    }