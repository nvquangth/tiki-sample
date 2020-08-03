package com.example.tikisample.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.tikisample.data.model.Banner
import com.example.tikisample.data.remote.ApiService
import com.example.tikisample.data.remote.Resource
import com.example.tikisample.data.remote.handleException

/**
 * Created by Quang Nguyen on 7/31/20.
 */
class BannerRepository(
    private val api: ApiService
) {

    fun getBanners(): LiveData<Resource<List<Banner>>> = liveData {
        emit(Resource.loading(null))

        try {
            val data = api.getBanners().data
            emit(Resource.success(data))
        } catch (e: Exception) {
            val ex = handleException(e)
            emit(Resource.error(ex, null))
        }
    }
}