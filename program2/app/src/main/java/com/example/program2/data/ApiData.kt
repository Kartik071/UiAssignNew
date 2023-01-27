package com.example.program2.data

import com.example.program2.DataModelItem
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiData {
    @GET("users")
    fun getData() : Observable<List<DataModelItem>>
}