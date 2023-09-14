package com.marcosconforti.horocopeapp.ui.horoscope.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.marcosconforti.horocopeapp.R
import com.marcosconforti.horocopeapp.domain.model.HoroscopeModel

class HoroscopeAdapter(private var horoscopeList: List<HoroscopeModel> = emptyList(),
    private val onItemSelected:(HoroscopeModel)->Unit) :
    RecyclerView.Adapter<HoroscopeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoroscopeViewHolder {
        return HoroscopeViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_horoscope, parent, false)
        )
    }
    override fun onBindViewHolder(holder: HoroscopeViewHolder, position: Int) {
        holder.render(horoscopeList[position], onItemSelected)
    }
    override fun getItemCount() = horoscopeList.size

    fun updateList(list: List<HoroscopeModel>){
        horoscopeList = list
        notifyDataSetChanged()
    }
}