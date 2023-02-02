package com.example.cleanarchitecturewithadapter.domain.repository

import com.example.cleanarchitecturewithadapter.data.data_source.dto.CoinDetailDto.CoinDetailDto
import com.example.cleanarchitecturewithadapter.data.data_source.dto.CoinListDto.CoinListDto

interface CoinRepository {

    suspend fun getAllCoins(page : String): CoinListDto
    suspend fun getCoinsById(id: String): CoinDetailDto
}