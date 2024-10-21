package com.example.blogs.data


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Links(
    @SerializedName("about")
    val about: List<About?>? = null,
    @SerializedName("author")
    val author: List<Author?>? = null,
    @SerializedName("collection")
    val collection: List<Collection?>? = null,
    @SerializedName("curies")
    val curies: List<Cury?>? = null,
    @SerializedName("predecessor-version")
    val predecessorVersion: List<PredecessorVersion?>? = null,
    @SerializedName("replies")
    val replies: List<Reply?>? = null,
    @SerializedName("self")
    val self: List<Self?>? = null,
    @SerializedName("version-history")
    val versionHistory: List<VersionHistory?>? = null,
    @SerializedName("wp:attachment")
    val wpAttachment: List<WpAttachment?>? = null,
    @SerializedName("wp:featuredmedia")
    val wpFeaturedmedia: List<WpFeaturedmedia?>? = null,
    @SerializedName("wp:term")
    val wpTerm: List<WpTerm?>? = null
) : Parcelable