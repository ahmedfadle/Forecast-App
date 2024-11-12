package com.dailyforecast.app.ui

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.fragment.app.viewModels
import com.dailyforecast.app.common.base.BaseFragment
import com.dailyforecast.app.common.model.DataSourseType
import com.dailyforecast.app.common.model.getData
import com.dailyforecast.app.common.model.getDataSourceType
import com.dailyforecast.app.databinding.FragmentForecastBinding
import com.dailyforecast.app.domain.models.City
import com.dailyforecast.app.domain.models.ForecastItem
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ForecastFragment : BaseFragment<FragmentForecastBinding>() {
    val TAG: String = "ForecastFragmentLogs"

    private val viewModel: ForecastViewModel by viewModels()
    private lateinit var cityAdapter: CitiesDropDownAdapter
    private lateinit var forecastAdapter: ForecastAdapter
    private var selectedCity: City? = null
    private var cities:List<City>? = null
    private var forecastItemList:List<ForecastItem>? = null


    override fun getViewBinding(): FragmentForecastBinding =
        FragmentForecastBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getCities()
        handleListner()
        handleObservable()
    }

    private fun handleListner() {
        binding.btnTryAgain.setOnClickListener(){
            if (cities.isNullOrEmpty() ) {
                viewModel.getCities()
            }else  if (selectedCity != null && selectedCity?.lat != null && selectedCity?.lon != null) {
                viewModel.getForecastByCity(selectedCity?.lat!!,selectedCity?.lon!!)
            }
        }
        binding.btnSearch.setOnClickListener() {
            if (selectedCity != null && selectedCity?.lat != null && selectedCity?.lon != null) {
                viewModel.getForecastByCity(selectedCity?.lat!!, selectedCity?.lon!!)
            }

        }

        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (::cityAdapter.isInitialized) {
                    selectedCity = cityAdapter.items[position]
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                selectedCity = null
            }
        }
    }

    private fun handleObservable() {
        viewModel.getCitiesObservable().observe(viewLifecycleOwner) { result ->
            result.let {
                handleWarningMessage(result.getDataSourceType() ?: DataSourseType.REMOTE)
                when {
                    it.isLoading() -> {
                        loadingView()
                    }

                    it.isSuccessful() -> {
                        successView()

                        if (it.getData() .isNullOrEmpty())
                            binding.tvNoDataMessage.visibility=View.VISIBLE
                        else {
                            cities = it.getData()
                            binding.tvNoDataMessage.visibility=View.GONE
                            cityAdapter = CitiesDropDownAdapter(
                                requireContext(),
                                items = it.getData() ?: emptyList()
                            )
                            binding.spinner.adapter = cityAdapter
                        }
                    }

                    it.isFailed() -> {
                        erroView()
                    }
                }
            }
        }
        viewModel.getForecastObservable().observe(viewLifecycleOwner) { result ->
            result.let {
                handleWarningMessage(result.getDataSourceType() ?: DataSourseType.REMOTE)
                when {
                    it.isLoading() -> {
                        loadingView()
                    }

                    it.isSuccessful() -> {
                        successView()

                        if (it.getData() != null && !it.getData()?.list.isNullOrEmpty()) {
                            forecastItemList = it.getData()?.list
                            forecastAdapter = ForecastAdapter(it.getData()?.list!!)
                            binding.rvForecast.adapter = forecastAdapter
                            binding.tvNoDataMessage.visibility=View.GONE
                        }else{
                            binding.tvNoDataMessage.visibility=View.VISIBLE
                        }
                    }

                    it.isFailed() -> {
                        erroView()
                    }
                }
            }
        }
    }

    private fun successView() {
        binding.errorContainer.visibility = View.GONE
        binding.loading.visibility = View.GONE
        binding.errorContainer.visibility = View.GONE
        binding.rvForecast.visibility = View.VISIBLE
    }

    private fun erroView() {
        binding.errorContainer.visibility = View.VISIBLE
        binding.loading.visibility = View.GONE
        binding.errorContainer.visibility = View.VISIBLE
        binding.rvForecast.visibility = View.GONE
    }

    private fun loadingView() {
        binding.rvForecast.visibility = View.GONE
        binding.errorContainer.visibility = View.GONE
        binding.loading.visibility = View.VISIBLE
        binding.errorContainer.visibility = View.GONE
    }

    private fun handleWarningMessage(dataSourseType: DataSourseType) {
        when (dataSourseType) {
            DataSourseType.REMOTE -> {
                binding.tvWarning.visibility = View.GONE
            }
            DataSourseType.LOCAL -> {
                binding.tvWarning.visibility = View.VISIBLE
            }
            else -> {
                binding.tvWarning.visibility = View.GONE
            }
        }
    }


    companion object {
        @JvmStatic
        fun newInstance() = ForecastFragment()
    }


}