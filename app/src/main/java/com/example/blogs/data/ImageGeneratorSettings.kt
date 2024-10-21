package com.example.blogs.data


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class ImageGeneratorSettings(
    @SerializedName("enabled")
    val enabled: Boolean? = null,
    @SerializedName("template")
    val template: String? = null
) : Parcelable