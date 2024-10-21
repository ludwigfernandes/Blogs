package com.example.blogs.data


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class PredecessorVersion(
    @SerializedName("href")
    val href: String? = null,
    @SerializedName("id")
    val id: Int? = null
) : Parcelable