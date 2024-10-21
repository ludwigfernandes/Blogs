package com.example.blogs.data


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Cury(
    @SerializedName("href")
    val href: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("templated")
    val templated: Boolean? = null
) : Parcelable