package com.example.tikisample.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.tikisample.data.model.FlashDeal
import com.example.tikisample.data.remote.ApiService
import com.example.tikisample.data.remote.BaseException
import com.example.tikisample.data.remote.Resource
import com.example.tikisample.data.remote.handleException

/**
 * Created by Quang Nguyen on 7/31/20.
 */
class FlashDealRepository(
    private val api: ApiService
) {

    fun getFlashDeals(): LiveData<Resource<List<FlashDeal>>> = liveData {
        emit(Resource.loading(null))

        try {
            val data = api.getFlashDeals().data
            if (data.isNullOrEmpty()) {
                emit(Resource.error(BaseException.toUnexpectedError(null), null))
            } else {
                emit(Resource.success(data))
            }
        } catch (e: Exception) {
            val ex = handleException(e)
            emit(Resource.error(ex, null))
        }
    }
}