package com.example.i_mo

import retrofit2.http.GET

interface ApiService {
    @GET("barang.php")
    suspend fun getBarang(): ApiResponse
}