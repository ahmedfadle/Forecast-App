package com.dailyforecast.app.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dailyforecast.app.databinding.ItemForecastBinding
import com.dailyforecast.app.domain.models.ForecastItem

class ForecastAdapter(
    private val dataList: List<ForecastItem>
) : RecyclerView.Adapter<ForecastAdapter.ForecastViewHolder>() {




    override fun getItemCount(): Int = dataList.size



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder =
        ForecastViewHolder(ItemForecastBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {
        holder.bind(dataList[position])
    }



    inner class ForecastViewHolder(val _itemView: ItemForecastBinding) :
        RecyclerView.ViewHolder(_itemView.root) {

        fun bind(summary: ForecastItem) {

            _itemView.tvDate.text = summary.dt_txt
            _itemView.tvTempValue.text = "${summary.main?.temp_max }/${summary.main?.temp_min}"
            _itemView.tvWeatherDescValue.text = summary.weather?.get(0)?.description
            _itemView.tvWeatherMainValue.text = summary.weather?.get(0)?.main
        }
    }
}