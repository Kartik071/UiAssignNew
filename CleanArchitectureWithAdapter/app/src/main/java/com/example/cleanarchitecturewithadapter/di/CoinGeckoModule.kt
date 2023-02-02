package com.example.cleanarchitecturewithadapter.di

import com.example.cleanarchitecturewithadapter.data.repository.Interceptor
import com.example.cleanarchitecturewithadapter.data.data_source.CoinGeckoApi
import com.example.cleanarchitecturewithadapter.data.repository.CoinRepositoryImpl
import com.example.cleanarchitecturewithadapter.domain.repository.CoinRepository
import com.example.cleanarchitecturewithadapter.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)


object CoinGeckoModule {
    private val client = Interceptor()

    @Provides
    @Singleton
    fun provideCoinGeckoApi(): CoinGeckoApi {
        return Retrofit.Builder().client(client.okHttpClient() as OkHttpClient).baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(CoinGeckoApi::class.java)

    }
    @Provides
    @Singleton
    fun provideCoinGeckoRepository(api: CoinGeckoApi): CoinRepository{
        return CoinRepositoryImpl(api)

    }

}