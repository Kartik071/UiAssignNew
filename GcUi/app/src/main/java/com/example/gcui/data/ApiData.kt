package com.example.gcui.data

import com.example.gcui.model.MainModel
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.HeaderMap

interface ApiData {

    @GET("giftCard/giftCardDetails.json")
    fun getData(@HeaderMap header: Map<String,String>)
    : Observable<Response<MainModel>>


}