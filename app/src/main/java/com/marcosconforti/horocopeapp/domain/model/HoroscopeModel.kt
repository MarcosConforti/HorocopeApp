package com.marcosconforti.horocopeapp.domain.model

import com.marcosconforti.horocopeapp.R

/* Siguiendo Clean Architecture, Dominio no tiene que saber nada de Android
*  colocamos Int porque pasaremos referencias
*  luego, en las otras capas utilizaremos los valores correspondientes
 */
sealed class HoroscopeModel(val image: Int, val name: Int) {

    data object Aries : HoroscopeModel(R.drawable.aries, R.string.aries)
    data object Taurus : HoroscopeModel(R.drawable.tauro, R.string.taurus)
    data object Cancer : HoroscopeModel(R.drawable.cancer, R.string.cancer)
    data object Geminis : HoroscopeModel(R.drawable.geminis, R.string.gemini)
    data object Leo : HoroscopeModel(R.drawable.leo, R.string.leo)
    data object Virgo : HoroscopeModel(R.drawable.virgo, R.string.virgo)
    data object Libra : HoroscopeModel(R.drawable.libra, R.string.libra)
    data object Escorpio : HoroscopeModel(R.drawable.escorpio, R.string.scorpio)
    data object Sagitarius : HoroscopeModel(R.drawable.sagitario, R.string.sagittarius)
    data object Capricorn : HoroscopeModel(R.drawable.capricornio, R.string.capricorn)
    data object Aquarius : HoroscopeModel(R.drawable.aquario, R.string.aquarius)
    data object Pisces : HoroscopeModel(R.drawable.piscis, R.string.pisces)
}
