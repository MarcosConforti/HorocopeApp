package com.marcosconforti.horocopeapp.ui.horoscope.adapter

import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.marcosconforti.horocopeapp.databinding.ItemHoroscopeBinding
import com.marcosconforti.horocopeapp.domain.model.HoroscopeModel

class HoroscopeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemHoroscopeBinding.bind(view)

    fun render(horoscope: HoroscopeModel, onItemSelected: (HoroscopeModel) -> Unit) {

        val context = binding.tvTittle.context

        binding.ivHoroscope.setImageResource(horoscope.image)
        binding.tvTittle.text = context.getString(horoscope.name)
        binding.itemView.setOnClickListener {
            starRotationAnimation(binding.ivHoroscope, onAnimatedItem = {
                onItemSelected(horoscope)
            })
        }
    }

    fun starRotationAnimation(view: View, onAnimatedItem: () -> Unit) {
        view.animate().apply {
            duration = 500
            interpolator = LinearInterpolator()
            rotationBy(360f)
            withEndAction { onAnimatedItem() }
            start()
        }

    }
}