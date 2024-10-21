package com.example.blogs.data


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Cury(
    @SerializedName("href")
    val href: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("templated")
    val templated: Boolean? = null
) : Parcelable