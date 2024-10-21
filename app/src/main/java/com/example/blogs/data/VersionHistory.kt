package com.example.blogs.data


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class VersionHistory(
    @SerializedName("count")
    val count: Int? = null,
    @SerializedName("href")
    val href: String? = null
) : Parcelable