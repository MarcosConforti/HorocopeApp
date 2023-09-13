package com.marcosconforti.horocopeapp.ui.horoscope

import com.marcosconforti.horocopeapp.data.provides.HoroscopeProvider
import com.marcosconforti.horocopeapp.motherobject.PredictionMotherObject.horoscopeModelList
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class HoroscopeViewModelTest{

    @MockK
    lateinit var horoscopeProvider: HoroscopeProvider

    private lateinit var viewModel: HoroscopeViewModel

    @Before
    fun setUp(){
        MockKAnnotations.init(this, relaxUnitFun = true)

    }

    @Test
    fun `when viewModel is created then horoscopes are loaded`(){
        every { horoscopeProvider.getHoroscope() } returns horoscopeModelList
        viewModel = HoroscopeViewModel(horoscopeProvider)

        val horoscope = viewModel.horoscope.value

        assertTrue(horoscope.isNotEmpty())
    }
}