package com.example.dagger2impl.core.di

import com.example.dagger2impl.core.di.Util.Constants
import com.example.dagger2impl.data.remote.Api.Endpoint
import com.example.dagger2impl.data.remote.Repository.ProductRepo
import com.example.dagger2impl.data.remote.Repository.ProductRepoImpl
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class FakeStoreModule {

    private val interceptor = kotlin.run {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.apply {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        }
    }

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .connectTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .build()

    @Provides
    @Singleton
    fun providesRetrofit(): Endpoint {
        return Retrofit.Builder().client(okHttpClient).baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build().create(Endpoint::class.java)
    }

    @Provides
    fun getRepoImpl(endpoint: Endpoint) : ProductRepo{
        return ProductRepoImpl(endpoint)
    }
}
