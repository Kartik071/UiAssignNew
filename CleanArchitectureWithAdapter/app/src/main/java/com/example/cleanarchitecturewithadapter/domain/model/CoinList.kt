package com.example.cleanarchitecturewithadapter.domain.model

data class CoinList(
    val name: String,
    val id : String,
    val image : String,
    val marketCap: Long,
    val price: Double,
    val pricePercentageChange : Double,
    val lowPrice : Double,
    val highPrice : Double
)
