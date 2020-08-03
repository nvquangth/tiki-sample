package com.example.tikisample.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.tikisample.data.model.QuickLinkItem
import com.example.tikisample.data.model.QuickLinkPair
import com.example.tikisample.data.remote.ApiService
import com.example.tikisample.data.remote.Resource
import com.example.tikisample.data.remote.handleException

/**
 * Created by Quang Nguyen on 7/31/20.
 */
class QuickLinkRepository(
    private val api: ApiService
) {

    fun getQuickLinks(): LiveData<Resource<List<QuickLinkPair>>> = liveData {
        emit(Resource.loading(null))

        try {
            val data = api.getQuickLinks().data
            emit(Resource.success(generateQuickLinkPairs(data)))
        } catch (e: Exception) {
            val ex = handleException(e)
            emit(Resource.error(ex, null))
        }
    }

    private fun generateQuickLinkPairs(quickLink: List<List<QuickLinkItem>>?): List<QuickLinkPair> {
        val result = arrayListOf<QuickLinkPair>()
        val ql1 = quickLink?.get(0) ?: listOf()
        val ql2 = quickLink?.get(1) ?: listOf()

        if (ql1.size > ql2.size) {
            ql2.forEachIndexed { index, item ->
                result.add(QuickLinkPair(ql1[index], item))
            }
            ql1.subList(ql2.size, ql1.size).forEach {
                result.add(QuickLinkPair(it, null))
            }
        } else {
            ql1.forEachIndexed { index, item ->
                result.add(QuickLinkPair(item, ql2[index]))
            }
            ql2.subList(ql1.size, ql2.size).forEach {
                result.add(QuickLinkPair(null, it))
            }
        }

        return result
    }
}