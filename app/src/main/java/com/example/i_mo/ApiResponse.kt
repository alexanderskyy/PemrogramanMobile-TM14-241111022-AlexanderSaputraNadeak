package com.example.i_mo

data class ApiResponse(
    val success: Boolean,
    val message: String,
    val data: List<Item>
)