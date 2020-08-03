package com.example.tikisample.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by Quang Nguyen on 7/30/20.
 */

@Parcelize
data class QuickLinkItem(
    val title: String? = null,
    val content: String? = null,
    val url: String? = null,
    val authentication: Boolean? = null,
    @SerializedName("web_url")
    val webUrl: String? = null,
    @SerializedName("image_url")
    val imageUrl: String? = null
) : Parcelable