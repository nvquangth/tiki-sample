package com.example.tikisample.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by Quang Nguyen on 7/31/20.
 */

@Parcelize
data class Banner(
    val id: Int,
    val title: String? = null,
    val content: String? = null,
    val url: String? = null,
    @SerializedName("image_url")
    val imageUrl: String? = null,
    @SerializedName("thumbnail_url")
    val thumbnailUrl: String? = null,
    @SerializedName("mobile_url")
    val mobileUrl: String? = null,
    val ratio: Float? = null
) : Parcelable