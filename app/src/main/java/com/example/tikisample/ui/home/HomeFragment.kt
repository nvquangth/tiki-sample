package com.example.tikisample.ui.home

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.example.mvvmarchitecture.utils.GlideApp
import com.example.tikisample.R
import com.example.tikisample.base.BaseFragment
import com.example.tikisample.data.model.FlashDeal
import com.example.tikisample.data.model.QuickLinkItem
import com.example.tikisample.databinding.FragmentHomeBinding
import com.example.tikisample.ui.home.banner.BannerPagerAdapter
import com.example.tikisample.widgets.SpacesItemDecoration
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Created by Quang Nguyen on 7/30/20.
 */
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    override val viewModel: HomeViewModel by viewModel()

    override val layoutId: Int = R.layout.fragment_home

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        GlideApp.with(requireContext())
            .load(R.drawable.flash)
            .into(viewBinding.gifFlash)

        viewBinding.swipeRefreshLayout.setOnRefreshListener {
            viewModel.refreshHome()
            viewBinding.swipeRefreshLayout.isRefreshing = false
        }

        val bannerAdapter = BannerPagerAdapter(childFragmentManager)
        viewBinding.pagerBanner.adapter = bannerAdapter

        val quickLinkAdapter = QuickLinkAdapter(::onItemQuickLinkClick)
        viewBinding.recyclerQuickLink.apply {
            addItemDecoration(SpacesItemDecoration(requireContext()))
            adapter = quickLinkAdapter
        }

        val flashDealAdapter =
            FlashDealAdapter(::onItemFlashDealClick, ::onItemViewMoreFlashDealClick)
        viewBinding.recyclerFlashDeal.apply {
            addItemDecoration(SpacesItemDecoration(requireContext()))
            adapter = flashDealAdapter
        }

        viewModel.apply {
            banners.observe(viewLifecycleOwner, Observer {
                it.data?.let { banners ->
                    bannerAdapter.setBanners(banners)
                }
            })
            quickLinkPairs.observe(viewLifecycleOwner, Observer {
                viewBinding.quickLinkResource = it
                it.data?.let { quickLinks ->
                    quickLinkAdapter.submitList(quickLinks.toMutableList())
                }
            })
            flashDeals.observe(viewLifecycleOwner, Observer {
                viewBinding.flashDealResource = it
                it.data?.let { flashDeals ->
                    flashDealAdapter.submitList(flashDeals.toMutableList())
                }
            })
        }
    }

    private fun onItemQuickLinkClick(quickLink: QuickLinkItem?) {

    }

    private fun onItemFlashDealClick(flashDeal: FlashDeal?) {

    }

    private fun onItemViewMoreFlashDealClick() {

    }
}