package com.marcosconforti.horocopeapp.ui.detail

import com.marcosconforti.horocopeapp.domain.model.HoroscopeInfo

sealed class HoroscopeDetailState {
    data object Loading:HoroscopeDetailState()
    data class Error(val error:String):HoroscopeDetailState()
    data class Success(val data:String, val sign:String, val horoscopeInfo: HoroscopeInfo):HoroscopeDetailState()
}