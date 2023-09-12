package com.marcosconforti.horocopeapp.domain.usecase

import com.marcosconforti.horocopeapp.domain.Repository
import javax.inject.Inject

class GetPredictionUseCase @Inject constructor(private val repository: Repository) {

    suspend operator fun invoke(sign:String) = repository.getHoroscope(sign)
}