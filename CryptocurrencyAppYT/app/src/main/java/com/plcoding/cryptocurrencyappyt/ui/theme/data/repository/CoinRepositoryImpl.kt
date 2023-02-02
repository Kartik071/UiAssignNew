package com.plcoding.cryptocurrencyappyt.ui.theme.data.repository

import com.plcoding.cryptocurrencyappyt.ui.theme.data.remote.dto.CoinDetailsDto
import com.plcoding.cryptocurrencyappyt.ui.theme.data.remote.dto.CoinsDto
import com.plcoding.cryptocurrencyappyt.ui.theme.data.remote.dto.ConPaprikaApi
import com.plcoding.cryptocurrencyappyt.ui.theme.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api :ConPaprikaApi
): CoinRepository {
    override suspend fun getCoins(): List<CoinsDto> {
    return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailsDto {
      return api.getCoinById(coinId)
        
    }
}