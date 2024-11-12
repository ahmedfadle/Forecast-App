package com.dailyforecast.app.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dailyforecast.app.common.model.IResult
import com.dailyforecast.app.common.utils.SingleLiveEvent
import com.dailyforecast.app.domain.models.City
import com.dailyforecast.app.domain.models.ForecastModel
import com.dailyforecast.app.domain.usecases.GetCitiesUseCase
import com.dailyforecast.app.domain.usecases.GetCitiesUseCaseImp
import com.dailyforecast.app.domain.usecases.GetForecastUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ForecastViewModel @Inject constructor( private val getCitiesUseCase: GetCitiesUseCase,
                                             private val getForecastUseCase: GetForecastUseCase) : ViewModel() {

    private val citiesLiveData by lazy { SingleLiveEvent<IResult<List<City>>>() }

    fun getCitiesObservable()=citiesLiveData


    private val forecastLiveData by lazy { SingleLiveEvent<IResult<ForecastModel>>() }

    fun getForecastObservable()=forecastLiveData


    fun getCities(){
        try {
            citiesLiveData.value = IResult.loading()
            viewModelScope.launch {
                val result = getCitiesUseCase.invoke()
                citiesLiveData.postValue(result)
            }
        }catch (e:Exception){
            citiesLiveData.postValue(IResult.failure(e.localizedMessage ?: ""))
        }
    }

    fun getForecastByCity(lat:Double,lon:Double){
        try {
            forecastLiveData.value = IResult.loading()
            viewModelScope.launch {
                val result = getForecastUseCase.invoke(lat,lon,"9ec40764d9d113e49494b7ffab0da5f0")
                forecastLiveData.postValue(result)
            }
        }catch (e:Exception){
            forecastLiveData.postValue(IResult.failure(e.localizedMessage?: ""))
        }
    }

}