package com.example.blogs.data


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Self(
    @SerializedName("href")
    val href: String? = null,
    @SerializedName("targetHints")
    val targetHints: TargetHints? = null
) : Parcelable