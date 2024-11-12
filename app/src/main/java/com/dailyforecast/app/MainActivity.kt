package com.dailyforecast.app

import androidx.activity.viewModels
import com.dailyforecast.app.common.base.BaseActivity
import com.dailyforecast.app.databinding.ActivityMainBinding
import com.dailyforecast.app.ui.ForecastFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {


    override fun getViewBinding(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)


    override fun initOnCreate() {
        addFragment(R.id.container_main, ForecastFragment.newInstance(), "ForecastFragment")

    }
}