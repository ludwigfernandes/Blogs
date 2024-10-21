package com.example.blogs.data


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ImageGeneratorSettings(
    @SerializedName("enabled")
    val enabled: Boolean? = null,
    @SerializedName("template")
    val template: String? = null
) : Parcelable