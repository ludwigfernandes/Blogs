package com.example.blogs.data


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Title(
    @SerializedName("rendered")
    val rendered: String? = null
) : Parcelable