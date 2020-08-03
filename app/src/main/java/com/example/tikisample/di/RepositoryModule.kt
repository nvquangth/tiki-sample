package com.example.tikisample.di

import com.example.tikisample.data.repository.BannerRepository
import com.example.tikisample.data.repository.FlashDealRepository
import com.example.tikisample.data.repository.HomeRepository
import com.example.tikisample.data.repository.QuickLinkRepository
import org.koin.dsl.module

/**
 * Created by Quang Nguyen on 6/3/20.
 */

val repositoryModule = module {
    single { BannerRepository(get()) }
    single { QuickLinkRepository(get()) }
    single { FlashDealRepository(get()) }
    single { HomeRepository(get()) }
}