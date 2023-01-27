package com.example.program2.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataModelItem(
    val email: String,
    val gender: String,
    val id: Int,
    val name: String,
    val status: String
) : Parcelable