package com.marcosconforti.horocopeapp.data.network.response

import com.google.gson.annotations.SerializedName
import com.marcosconforti.horocopeapp.domain.model.PredictionModel

data class PredictionResponse(
    @SerializedName("date") val date: String,
    @SerializedName("horoscope") val horoscope: String,
    @SerializedName("sign") val sign: String
)

fun PredictionResponse.toDomain(): PredictionModel = PredictionModel(horoscope, sign)
