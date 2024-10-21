package com.example.blogs.data


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Title(
    @SerializedName("rendered")
    val rendered: String? = null
) : Parcelable