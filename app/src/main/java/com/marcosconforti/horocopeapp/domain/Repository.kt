package com.marcosconforti.horocopeapp.domain

import com.marcosconforti.horocopeapp.domain.model.PredictionModel

interface Repository {

    suspend fun getHoroscope(sign:String): PredictionModel?
}