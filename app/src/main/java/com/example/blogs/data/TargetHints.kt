package com.example.blogs.data


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class TargetHints(
    @SerializedName("allow")
    val allow: List<String?>? = null
) : Parcelable