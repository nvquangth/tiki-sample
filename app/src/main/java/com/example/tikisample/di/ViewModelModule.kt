package com.example.tikisample.di

import com.example.tikisample.ui.home.HomeViewModel
import com.example.tikisample.ui.home.banner.BannerViewModel
import com.example.tikisample.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Quang Nguyen on 6/3/20.
 */

val viewModelModule = module {
    viewModel { MainViewModel() }
    viewModel { HomeViewModel(get(), get(), get()) }
    viewModel { BannerViewModel() }
}