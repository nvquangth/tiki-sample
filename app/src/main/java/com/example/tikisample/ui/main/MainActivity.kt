package com.example.tikisample.ui.main

import com.example.tikisample.R
import com.example.tikisample.base.BaseActivity
import com.example.tikisample.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override val viewModel: MainViewModel by viewModel()

    override val layoutId: Int = R.layout.activity_main
}