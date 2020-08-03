package com.example.tikisample.ui.home.banner

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import com.example.tikisample.R
import com.example.tikisample.base.BaseFragment
import com.example.tikisample.data.model.Banner
import com.example.tikisample.databinding.FragmentBannerBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Created by Quang Nguyen on 7/31/20.
 */
class BannerFragment : BaseFragment<FragmentBannerBinding, BannerViewModel>() {

    companion object {
        private const val ARGUMENT_BANNER = "argument_banner"

        fun newInstance(banner: Banner): BannerFragment = BannerFragment().apply {
            arguments = bundleOf(
                ARGUMENT_BANNER to banner
            )
        }
    }

    override val viewModel: BannerViewModel by viewModel()

    override val layoutId: Int = R.layout.fragment_banner

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val banner = arguments?.getParcelable<Banner>(ARGUMENT_BANNER)

        viewModel.setBanner(banner)
    }
}