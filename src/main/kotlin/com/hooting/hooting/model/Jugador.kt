package com.Hoot.hoot.model


import com.hooting.hooting.model.Puntaje

class Jugador(val nombre: String) {

    var puntaje: Puntaje = Puntaje()
    lateinit var jugadorSiguiente: Jugador


    fun agregarMultiplicador(factor: Int) {
        puntaje.agregarMultiplicador(factor)
    }

    fun sumarPuntos(puntaje: Int) {
        this.puntaje.sumarPuntos(puntaje)
    }

}
