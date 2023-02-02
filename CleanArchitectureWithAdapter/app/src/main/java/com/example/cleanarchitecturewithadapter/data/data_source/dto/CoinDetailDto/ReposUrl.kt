package com.example.cleanarchitecturewithadapter.data.data_source.dto.CoinDetailDto


import com.google.gson.annotations.SerializedName

data class ReposUrl(
    @SerializedName("bitbucket")
    val bitbucket: List<Any>,
    @SerializedName("github")
    val github: List<String>
)