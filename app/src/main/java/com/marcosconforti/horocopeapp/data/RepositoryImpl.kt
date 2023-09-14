package com.marcosconforti.horocopeapp.data

import android.util.Log
import com.marcosconforti.horocopeapp.data.network.HoroscopeApiService
import com.marcosconforti.horocopeapp.data.network.response.toDomain
import com.marcosconforti.horocopeapp.domain.Repository
import com.marcosconforti.horocopeapp.domain.model.PredictionModel

class RepositoryImpl(private val apiService: HoroscopeApiService) : Repository {

    override suspend fun getHoroscope(sign: String): PredictionModel? {
        runCatching { apiService.getHoroscope(sign) }
            .onSuccess { return it.toDomain() }
            .onFailure { Log.e("marcos","Ha ocurrido un error ${it.message}")}
        return null
    }
}