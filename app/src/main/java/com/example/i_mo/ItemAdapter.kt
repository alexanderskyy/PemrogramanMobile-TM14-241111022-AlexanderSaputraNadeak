package com.example.i_mo

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(
    private val items: List<Item>,
    private val onClick: (Item) -> Unit
) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvNamaBarang: TextView = view.findViewById(R.id.tvNamaBarang)
        val tvHarga: TextView = view.findViewById(R.id.tvHarga)
        val tvKategori: TextView = view.findViewById(R.id.tvKategori)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_barang, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.tvNamaBarang.text = item.nama_barang
        holder.tvHarga.text = "Rp ${String.format("%,d", item.harga).replace(',', '.')}"
        holder.tvKategori.text = item.kategori
        holder.itemView.setOnClickListener { onClick(item) }
    }

    override fun getItemCount() = items.size
}