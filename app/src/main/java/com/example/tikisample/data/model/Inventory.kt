package com.example.tikisample.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by Quang Nguyen on 7/31/20.
 */

@Parcelize
data class Inventory(
    @SerializedName("product_virtual_type")
    val productVirtualType: String? = null,
    @SerializedName("fulfillment_type")
    val fulfillmentType: String? = null
) : Parcelable