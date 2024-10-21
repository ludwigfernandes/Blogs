package com.example.blogs.data


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class JetpackSocialOptions(
    @SerializedName("image_generator_settings")
    val imageGeneratorSettings: ImageGeneratorSettings? = null,
    @SerializedName("version")
    val version: Int? = null
) : Parcelable