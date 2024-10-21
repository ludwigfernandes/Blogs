package com.example.blogs.data


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Self(
    @SerializedName("href")
    val href: String? = null,
    @SerializedName("targetHints")
    val targetHints: TargetHints? = null
) : Parcelable