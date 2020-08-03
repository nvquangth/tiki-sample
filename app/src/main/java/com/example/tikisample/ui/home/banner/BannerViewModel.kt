package com.example.tikisample.ui.home.banner

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tikisample.base.BaseViewModel
import com.example.tikisample.data.model.Banner

/**
 * Created by Quang Nguyen on 7/31/20.
 */
class BannerViewModel : BaseViewModel() {

    private val _banner = MutableLiveData<Banner>()
    val banner: LiveData<Banner>
        get() = _banner

    fun setBanner(b: Banner?) {
        _banner.value = b
    }
}