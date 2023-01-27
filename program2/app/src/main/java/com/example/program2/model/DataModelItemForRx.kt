package com.example.program2.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataModelItemForRx(
    val body: String,
    val id : Int,
    val title: String,
    val userId: Int
) : Parcelable
