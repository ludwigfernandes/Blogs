package com.example.blogs.data


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class WpTerm(
    @SerializedName("embeddable")
    val embeddable: Boolean? = null,
    @SerializedName("href")
    val href: String? = null,
    @SerializedName("taxonomy")
    val taxonomy: String? = null
) : Parcelable