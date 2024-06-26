package com.example.registrasiloginforgetpassword

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(private val namaList : ArrayList<Data>):RecyclerView.Adapter<Adapter.ViewHolder>() {

    private lateinit var mListener: onItemClickListener

    interface onItemClickListener {
        fun onItemClick (position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener) {
        mListener = listener
    }

    class ViewHolder (itemData : View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemData) {
        val foto : ImageView = itemData.findViewById(R.id.id_Foto)
        val nama : TextView = itemData.findViewById(R.id.id_Nama)
        //val handphone : TextView = itemData.findViewById(R.id.id_NoHp)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemData = LayoutInflater.from(parent.context).inflate(R.layout.example_item, parent, false)
        return ViewHolder(itemData, mListener)
    }

    override fun getItemCount(): Int {
        return namaList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = namaList[position]

        holder.foto.setImageResource(currentItem.foto)
        holder.nama.text = currentItem.nama
        //holder.handphone.text = currentItem.handphone
    }
}