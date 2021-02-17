package model.modificadores

import model.Jugador

interface Exclusividad {
    fun definirPuntosJugadoresEnPregunta(pregunta: Pregunta, jugadorActual: Jugador)
    fun activarExclusividad(): Exclusividad
    fun darPuntosAGanador(jugador: Jugador, puntosGanados: Int)
    fun darPuntosAPerdedor(jugador: Jugador, puntosGanados: Int)
}