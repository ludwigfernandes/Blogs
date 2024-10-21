package com.example.blogs.data


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class ArticlesItem(
    @SerializedName("aioseo_notices")
    val aioseoNotices: List<@RawValue Any?>? = null,
    @SerializedName("author")
    val author: Int? = null,
    @SerializedName("categories")
    val categories: List<Int?>? = null,
    @SerializedName("class_list")
    val classList: List<String?>? = null,
    @SerializedName("comment_status")
    val commentStatus: String? = null,
    @SerializedName("content")
    val content: Content? = null,
    @SerializedName("date")
    val date: String? = null,
    @SerializedName("date_gmt")
    val dateGmt: String? = null,
    @SerializedName("excerpt")
    val excerpt: Excerpt? = null,
    @SerializedName("featured_media")
    val featuredMedia: Int? = null,
    @SerializedName("format")
    val format: String? = null,
    @SerializedName("guid")
    val guid: Guid? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("jetpack_featured_media_url")
    val jetpackFeaturedMediaUrl: String? = null,
    @SerializedName("jetpack_likes_enabled")
    val jetpackLikesEnabled: Boolean? = null,
    @SerializedName("jetpack_publicize_connections")
    val jetpackPublicizeConnections: List<@RawValue Any?>? = null,
    @SerializedName("jetpack-related-posts")
    val jetpackRelatedPosts: List<@RawValue Any?>? = null,
    @SerializedName("jetpack_sharing_enabled")
    val jetpackSharingEnabled: Boolean? = null,
    @SerializedName("jetpack_shortlink")
    val jetpackShortlink: String? = null,
    @SerializedName("link")
    val link: String? = null,
    @SerializedName("_links")
    val links: Links? = null,
    @SerializedName("meta")
    val meta: Meta? = null,
    @SerializedName("modified")
    val modified: String? = null,
    @SerializedName("modified_gmt")
    val modifiedGmt: String? = null,
    @SerializedName("ping_status")
    val pingStatus: String? = null,
    @SerializedName("slug")
    val slug: String? = null,
    @SerializedName("status")
    val status: String? = null,
    @SerializedName("sticky")
    val sticky: Boolean? = null,
    @SerializedName("tags")
    val tags: List<Int?>? = null,
    @SerializedName("template")
    val template: String? = null,
    @SerializedName("title")
    val title: Title? = null,
    @SerializedName("type")
    val type: String? = null
) : Parcelable