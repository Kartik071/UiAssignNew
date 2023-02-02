package com.example.cleanarchitecturewithadapter.data.repository

import com.example.cleanarchitecturewithadapter.data.data_source.CoinGeckoApi
import com.example.cleanarchitecturewithadapter.data.data_source.dto.CoinDetailDto.CoinDetailDto
import com.example.cleanarchitecturewithadapter.data.data_source.dto.CoinListDto.CoinListDto
import com.example.cleanarchitecturewithadapter.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val coinApi : CoinGeckoApi
):CoinRepository{
    override suspend fun getAllCoins(page: String): CoinListDto {
    return coinApi.getAllCoins(page=page)
    }

    override suspend fun getCoinsById(id: String): CoinDetailDto {
        return coinApi.getCoinsById(id=id)
    }


}