package com.marcosconforti.horocopeapp.ui.horoscope

import androidx.lifecycle.ViewModel
import com.marcosconforti.horocopeapp.data.provides.HoroscopeProvider
import com.marcosconforti.horocopeapp.domain.model.HoroscopeModel
import com.marcosconforti.horocopeapp.domain.model.HoroscopeModel.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HoroscopeViewModel @Inject constructor(provider: HoroscopeProvider) : ViewModel() {

    private val _horoscope =
        MutableStateFlow<List<HoroscopeModel>>(emptyList())

    val horoscope: StateFlow<List<HoroscopeModel>> = _horoscope

    init{
        _horoscope.value = provider.getHoroscope()
    }
}