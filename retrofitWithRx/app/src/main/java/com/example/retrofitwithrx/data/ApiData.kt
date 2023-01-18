package com.example.retrofitwithrx.data

import com.example.retrofitwithrx.model.DataModelItem
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiData {

    @GET("posts")
    fun getData() : Observable<List<DataModelItem>>
}