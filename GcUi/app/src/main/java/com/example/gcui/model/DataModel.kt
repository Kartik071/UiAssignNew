package com.example.gcui.model

import com.google.gson.annotations.SerializedName
data class MainModel(
    @SerializedName("giftCardResponseList")
    val giftCardResponseList : ArrayList<DataModel> ){
    data class DataModel(
        @SerializedName("description")
        val description: String,
        @SerializedName("giftCardImageUrl")
        val giftCardImageUrl: String,
        @SerializedName("marketingContent01")
        val marketingContent01: String,
        @SerializedName("marketingContent02")
        val marketingContent02: String
    )
}