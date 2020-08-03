package com.example.tikisample.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by Quang Nguyen on 8/1/20.
 */
@Parcelize
data class QuickLinkPair(
    val quickLink1: QuickLinkItem? = null,
    val quickLink2: QuickLinkItem? = null
) : Parcelable