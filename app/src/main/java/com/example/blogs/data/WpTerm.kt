package com.example.blogs.data


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class WpTerm(
    @SerializedName("embeddable")
    val embeddable: Boolean? = null,
    @SerializedName("href")
    val href: String? = null,
    @SerializedName("taxonomy")
    val taxonomy: String? = null
) : Parcelable