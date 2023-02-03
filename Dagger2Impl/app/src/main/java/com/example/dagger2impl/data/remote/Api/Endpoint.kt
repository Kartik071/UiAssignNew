package com.example.dagger2impl.data.remote.Api

import com.example.dagger2impl.data.model.DataModel
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET

interface Endpoint {

    @GET("products")
    fun getProducts(): Observable<Response<DataModel>>

}
