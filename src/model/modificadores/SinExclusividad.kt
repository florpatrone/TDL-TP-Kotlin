package model.modificadores

import model.Jugador
import model.Pregunta

class SinExclusividad : Exclusividad {
    override fun activarExclusividad(): Exclusividad {
        return ExclusividadX2()
    }

    fun darPuntosAGanador(jugador: Jugador, puntosGanados: Int) {
        jugador.ganarPuntaje(puntosGanados)
    }

    fun darPuntosAPerdedor(jugador: Jugador, puntosGanados: Int) {
        jugador.ganarPuntaje(puntosGanados)
    }

    fun definirPuntosJugadoresEnPregunta(pregunta: Pregunta, jugadorActual: Jugador) {
        val puntosJugador1: Int = pregunta.obtenerPuntaje(jugadorActual.getRespuestasElegidas())
        val puntosJugador2: Int = pregunta.obtenerPuntaje(jugadorActual.getJugadorSiguiente().getRespuestasElegidas())
        this.darPuntosAGanador(jugadorActual, puntosJugador1)
        this.darPuntosAGanador(jugadorActual.getJugadorSiguiente(), puntosJugador2)
    }
}