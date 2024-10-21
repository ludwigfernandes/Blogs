package com.example.blogs.data


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class About(
    @SerializedName("href")
    val href: String? = null
) : Parcelable