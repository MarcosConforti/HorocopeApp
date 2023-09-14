package com.marcosconforti.horocopeapp.motherobject

import com.marcosconforti.horocopeapp.data.network.response.PredictionResponse
import com.marcosconforti.horocopeapp.domain.model.HoroscopeModel
import com.marcosconforti.horocopeapp.domain.model.HoroscopeModel.*

object PredictionMotherObject {

    val anyResponse = PredictionResponse("date", "you're great", "aries")

    val horoscopeModelList = listOf(
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