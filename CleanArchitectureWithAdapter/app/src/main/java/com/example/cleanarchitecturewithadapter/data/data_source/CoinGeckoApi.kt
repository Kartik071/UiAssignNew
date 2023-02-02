package com.example.cleanarchitecturewithadapter.data.data_source

import com.example.cleanarchitecturewithadapter.data.data_source.dto.CoinDetailDto.CoinDetailDto
import com.example.cleanarchitecturewithadapter.data.data_source.dto.CoinListDto.CoinListDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CoinGeckoApi {
   @GET("/api/v3/coins/markets?vs_currency=usd&order=market_cap_desc&per_page=100&sparkline=false")
   suspend fun getAllCoins(@Query("page")page:String):CoinListDto

   @GET("/api/v3/coins/{id}")
   suspend fun getCoinsById(@Path("id")id:String):CoinDetailDto

}