package com.example.tikisample.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by Quang Nguyen on 7/31/20.
 */

@Parcelize
data class FlashDeal(
    val status: Int? = null,
    val url: String? = null,
    val tags: String? = null,
    @SerializedName("discount_percent")
    val discountPercent: Float? = null,
    @SerializedName("special_price")
    val specialPrice: Float? = null,
    @SerializedName("special_from_date")
    val specialFromDate: Long? = null,
    @SerializedName("from_date")
    val fromDate: String? = null,
    @SerializedName("special_to_date")
    val specialToDate: Long? = null,
    val progress: Progress? = null,
    val product: Product? = null
) : Parcelable