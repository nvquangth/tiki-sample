package com.example.tikisample.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.example.tikisample.base.BaseViewModel
import com.example.tikisample.data.model.Banner
import com.example.tikisample.data.model.FlashDeal
import com.example.tikisample.data.model.QuickLinkPair
import com.example.tikisample.data.remote.Resource
import com.example.tikisample.data.remote.Status
import com.example.tikisample.data.repository.BannerRepository
import com.example.tikisample.data.repository.FlashDealRepository
import com.example.tikisample.data.repository.QuickLinkRepository

/**
 * Created by Quang Nguyen on 7/30/20.
 */
class HomeViewModel(
    private val bannerRepository: BannerRepository,
    private val quickLinkRepository: QuickLinkRepository,
    private val flashDealRepository: FlashDealRepository
) : BaseViewModel() {


    private val _refresh = MutableLiveData(true)
    val refresh: LiveData<Boolean>
        get() = _refresh

    private val _banners = MutableLiveData<Resource<List<Banner>>>()
    val banners: LiveData<Resource<List<Banner>>> = Transformations.switchMap(_refresh) {
        bannerRepository.getBanners()
    }

    private val _quickLinkPairs = MutableLiveData<Resource<List<QuickLinkPair>>>()
    val quickLinkPairs: LiveData<Resource<List<QuickLinkPair>>> =
        Transformations.switchMap(_refresh) {
            if (it == true) {
                quickLinkRepository.getQuickLinks()
            } else {
                null
            }
        }

    private val _shouldGetFlashDeal = MediatorLiveData<Boolean>().apply {
        addSource(banners) {
            value = shouldGetFlashDeals()
        }
        addSource(quickLinkPairs) {
            value = shouldGetFlashDeals()
        }
    }

    private val _flashDeals = MutableLiveData<Resource<List<FlashDeal>>>()
    val flashDeals = Transformations.switchMap(_shouldGetFlashDeal) {
        if (it == true) {
            flashDealRepository.getFlashDeals()
        } else {
            null
        }
    }

    private fun shouldGetFlashDeals(): Boolean {
        return (banners.value?.status == Status.ERROR || banners.value?.status == Status.SUCCESS) &&
                (quickLinkPairs.value?.status == Status.ERROR || quickLinkPairs.value?.status == Status.SUCCESS)
    }

    fun refreshHome() {
        _refresh.value = true
    }
}