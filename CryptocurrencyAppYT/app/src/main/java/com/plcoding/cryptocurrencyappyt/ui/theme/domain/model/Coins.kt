package com.plcoding.cryptocurrencyappyt.ui.theme.domain.model

import com.google.gson.annotations.SerializedName

data class Coins(
    val id: String,
    val isActive: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
)
