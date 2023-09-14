package com.marcosconforti.horocopeapp.data.provides

import com.marcosconforti.horocopeapp.domain.model.HoroscopeModel
import com.marcosconforti.horocopeapp.domain.model.HoroscopeModel.*
import javax.inject.Inject

class HoroscopeProvider @Inject constructor() {
    fun getHoroscope():List<HoroscopeModel>{
        return listOf(
            Aries,
            Taurus,
            Cancer,
            Geminis,
            Leo,
            Virgo,
            Escorpio,
            Libra,
            Sagitarius,
            Capricorn,
            Aquarius,
            Pisces
        )
    }
}