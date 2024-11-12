package com.dailyforecast.app.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.dailyforecast.app.R
import com.dailyforecast.app.domain.models.City

class CitiesDropDownAdapter(context: Context,
                             val items: List<City>
) : ArrayAdapter<City>(context, 0, items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return createViewFromResource(position, convertView, parent, R.layout.item_city)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return createViewFromResource(position, convertView, parent, R.layout.item_city)
    }

    private fun createViewFromResource(position: Int, convertView: View?, parent: ViewGroup, layout: Int): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(layout, parent, false)
        val item = items[position]

        val tvCity = view.findViewById<TextView>(R.id.tv_city)

        tvCity.text = item.cityNameEn

        return view
    }
}