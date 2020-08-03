package com.example.tikisample.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by Quang Nguyen on 7/31/20.
 */

@Parcelize
data class Product(
    val id: Int,
    val sku: String? = null,
    val name: String? = null,
    @SerializedName("url_path")
    val urlPath: String? = null,
    val price: Float? = null,
    @SerializedName("list_price")
    val listPrice: Float? = null,
    val badges: List<Badge>? = null,
    val discount: Float? = null,
    @SerializedName("rating_average")
    val ratingAverage: Float? = null,
    @SerializedName("review_count")
    val reviewCount: Int? = null,
    @SerializedName("order_count")
    val orderCount: Int? = null,
    @SerializedName("thumbnail_url")
    val thumbnailUrl: String? = null,
    @SerializedName("is_visible")
    val isVisible: Boolean? = null,
    @SerializedName("is_fresh")
    val isFresh: Boolean? = null,
    @SerializedName("is_flower")
    val isFlower: Boolean? = null,
    @SerializedName("is_gift_card")
    val isGiftCard: Boolean? = null,
    val inventory: Inventory? = null,
    @SerializedName("url_attendant_input_form")
    val urlAttendantInputForm: String? = null,
    @SerializedName("master_id")
    val masterId: Int? = null,
    @SerializedName("seller_product_id")
    val sellerProductId: Int? = null,
    @SerializedName("price_prefix")
    val pricePrefix: String? = null
) : Parcelable