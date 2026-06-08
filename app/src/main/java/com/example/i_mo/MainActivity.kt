package com.example.i_mo

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        lifecycleScope.launch {
            try {
                val response = RetrofitClient.instance.getBarang()
                recyclerView.adapter = ItemAdapter(response.data) { item ->
                    val intent = Intent(this@MainActivity, DetailActivity::class.java)
                    intent.putExtra("NAMA", item.nama_barang)
                    intent.putExtra("HARGA", item.harga)
                    intent.putExtra("KATEGORI", item.kategori)
                    intent.putExtra("STOK", item.stok)
                    intent.putExtra("DESKRIPSI", item.deskripsi)
                    startActivity(intent)
                }
            } catch (e: Exception) {
                Toast.makeText(this@MainActivity, "Gagal memuat data: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}