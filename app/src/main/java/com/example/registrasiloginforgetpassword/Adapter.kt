package com.example.registrasiloginforgetpassword

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(private val namaList : ArrayList<Data>):RecyclerView.Adapter<Adapter.ViewHolder>() {

    class ViewHolder (itemData : View) : RecyclerView.ViewHolder(itemData) {
        val gambar : ImageView = itemData.findViewById(R.id.iv_Foto)
        val nama : TextView = itemData.findViewById(R.id.tv_Nama)
        val handphone : TextView = itemData.findViewById(R.id.tv_NoHp)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemData = LayoutInflater.from(parent.context).inflate(R.layout.example_item, parent, false)
        return ViewHolder(itemData)
    }

    override fun getItemCount(): Int {
        return namaList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = namaList[position]

        holder.gambar.setImageResource(currentItem.gambar)
        holder.nama.text = currentItem.nama
        holder.handphone.text = currentItem.handphone
    }
}