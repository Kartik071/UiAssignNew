package com.plcoding.cryptocurrencyappyt.ui.theme.data.remote.dto

import retrofit2.http.GET
import retrofit2.http.Path

interface ConPaprikaApi {
    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinsDto>

    @GET("v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId:String):CoinDetailsDto


}