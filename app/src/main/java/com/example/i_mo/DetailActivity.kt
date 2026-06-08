package com.example.i_mo

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val nama = intent.getStringExtra("NAMA")
        val harga = intent.getIntExtra("HARGA", 0)
        val kategori = intent.getStringExtra("KATEGORI")
        val stok = intent.getIntExtra("STOK", 0)
        val deskripsi = intent.getStringExtra("DESKRIPSI")

        findViewById<TextView>(R.id.tvDetailNama).text = nama
        findViewById<TextView>(R.id.tvDetailHarga).text = "Rp ${String.format("%,d", harga).replace(',', '.')}"
        findViewById<TextView>(R.id.tvDetailKategori).text = kategori
        findViewById<TextView>(R.id.tvDetailStok).text = "Stok: $stok"
        findViewById<TextView>(R.id.tvDetailDeskripsi).text = deskripsi
    }
}