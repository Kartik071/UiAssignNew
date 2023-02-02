package com.example.cleanarchitecturewithadapter.data.data_source.dto.CoinDetailDto


import com.google.gson.annotations.SerializedName

data class CodeAdditionsDeletions4Weeks(
    @SerializedName("additions")
    val additions: Double,
    @SerializedName("deletions")
    val deletions: Double
)