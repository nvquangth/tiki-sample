package com.example.tikisample.ui.home.banner

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.tikisample.data.model.Banner

/**
 * Created by Quang Nguyen on 7/31/20.
 */

class BannerPagerAdapter(fm: FragmentManager, behavior: Int = BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) :
    FragmentPagerAdapter(fm, behavior) {

    private var banners = listOf<Banner>()

    override fun getItem(position: Int): Fragment = BannerFragment.newInstance(banners[position])

    override fun getCount(): Int= banners.size

    fun setBanners(data: List<Banner>) {
        banners = data
        notifyDataSetChanged()
    }
}