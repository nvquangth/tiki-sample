package com.example.tikisample.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by Quang Nguyen on 7/31/20.
 */

@Parcelize
data class Progress(
    val qty: Int? = null,
    @SerializedName("qty_ordered")
    val qtyOrdered: Int? = null,
    @SerializedName("qty_remain")
    val qtyRemain: Int? = null,
    val percent: Float? = null,
    val status: String? = null
) : Parcelable