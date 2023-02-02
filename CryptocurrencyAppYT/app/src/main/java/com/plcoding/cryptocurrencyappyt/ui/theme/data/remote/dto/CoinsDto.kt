package com.plcoding.cryptocurrencyappyt.ui.theme.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.plcoding.cryptocurrencyappyt.ui.theme.domain.model.Coins

data class CoinsDto(
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("is_new")
    val isNew: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)

fun CoinsDto.toCoin(): Coins {
    return Coins(
        id = id,
        isActive = isActive,
        name = name,
        rank = rank,
        symbol = symbol

    )
}