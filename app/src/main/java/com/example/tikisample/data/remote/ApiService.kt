package com.example.tikisample.data.remote

import com.example.tikisample.data.remote.response.BannerResponse
import com.example.tikisample.data.remote.response.FlashDealResponse
import com.example.tikisample.data.remote.response.QuickLinkResponse
import retrofit2.http.GET

/**
 * Created by Quang Nguyen on 7/30/20.
 */
interface ApiService {

    @GET("v2/home/banners/v2")
    suspend fun getBanners(): BannerResponse

    @GET("shopping/v2/widgets/quick_link")
    suspend fun getQuickLinks(): QuickLinkResponse

    @GET("v2/widget/deals/hot")
    suspend fun getFlashDeals(): FlashDealResponse
}