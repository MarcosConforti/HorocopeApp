package com.marcosconforti.horocopeapp.data.network.response

import com.marcosconforti.horocopeapp.motherobject.PredictionMotherObject.anyResponse
import io.kotlintest.shouldBe
import org.junit.Test

class PredictionResponseTest{

    @Test
    fun `toDomain should return a correct Prediction`(){
        //Given
        val predictionResponse = anyResponse.copy(sign = "libra")

        //When
        val predictionModel = predictionResponse.toDomain()

        //Then
        predictionModel.sign shouldBe  predictionResponse.sign
        predictionModel.horoscope shouldBe  predictionResponse.horoscope
    }
}