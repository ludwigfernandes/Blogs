package com.example.blogs.data


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class JetpackSocialOptions(
    @SerializedName("image_generator_settings")
    val imageGeneratorSettings: ImageGeneratorSettings? = null,
    @SerializedName("version")
    val version: Int? = null
) : Parcelable