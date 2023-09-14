package com.marcosconforti.horocopeapp.ui.providers

import org.junit.Assert.*
import org.junit.Test

class RandomCardProviderTest{

    @Test
    fun `getRandomCard should be return a random card`(){
        val randomCardProvider = RandomCardProvider()

        val card = randomCardProvider.getLucky()

        assertNotNull(card)
    }
}