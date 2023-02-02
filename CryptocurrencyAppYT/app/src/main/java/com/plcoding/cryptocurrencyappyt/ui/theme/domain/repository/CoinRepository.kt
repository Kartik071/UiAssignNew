package com.plcoding.cryptocurrencyappyt.ui.theme.domain.repository

import com.plcoding.cryptocurrencyappyt.ui.theme.data.remote.dto.CoinDetailsDto
import com.plcoding.cryptocurrencyappyt.ui.theme.data.remote.dto.CoinsDto

interface CoinRepository {
    suspend fun getCoins() :List<CoinsDto>

    suspend fun getCoinById(coinId :String): CoinDetailsDto
}