package com.example.blogs.data


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Meta(
    @SerializedName("footnotes")
    val footnotes: String? = null,
    @SerializedName("_jetpack_dont_email_post_to_subs")
    val jetpackDontEmailPostToSubs: Boolean? = null,
    @SerializedName("_jetpack_memberships_contains_paid_content")
    val jetpackMembershipsContainsPaidContent: Boolean? = null,
    @SerializedName("_jetpack_memberships_contains_paywalled_content")
    val jetpackMembershipsContainsPaywalledContent: Boolean? = null,
    @SerializedName("_jetpack_newsletter_access")
    val jetpackNewsletterAccess: String? = null,
    @SerializedName("_jetpack_newsletter_tier_id")
    val jetpackNewsletterTierId: Int? = null,
    @SerializedName("jetpack_post_was_ever_published")
    val jetpackPostWasEverPublished: Boolean? = null,
    @SerializedName("jetpack_publicize_feature_enabled")
    val jetpackPublicizeFeatureEnabled: Boolean? = null,
    @SerializedName("jetpack_publicize_message")
    val jetpackPublicizeMessage: String? = null,
    @SerializedName("jetpack_social_options")
    val jetpackSocialOptions: JetpackSocialOptions? = null,
    @SerializedName("jetpack_social_post_already_shared")
    val jetpackSocialPostAlreadyShared: Boolean? = null
) : Parcelable