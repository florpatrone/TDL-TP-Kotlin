package model.modificadores

import model.Jugador

class ExclusividadX2 : Exclusividad {
    private val valorExclusividad = 2
    override fun darPuntosAGanador(jugador: Jugador, puntosGanados: Int) {
        jugador.ganarPuntaje(valorExclusividad * puntosGanados)
    }

    override fun darPuntosAPerdedor(jugador: Jugador, puntosGanados: Int) {
        jugador.ganarPuntaje(puntosGanados)
    }

    override fun definirPuntosJugadoresEnPregunta(pregunta: Pregunta, jugadorActual: Jugador) {
        val puntosJugador1: Int = pregunta.obtenerPuntaje(jugadorActual.respuestasElegidas)
        val puntosJugador2: Int = pregunta.obtenerPuntaje(jugadorActual.jugadorSiguiente.respuestasElegidas)
        if (puntosJugador1 == puntosJugador2) return
        if (puntosJugador1 > puntosJugador2) {
            this.darPuntosAGanador(jugadorActual, puntosJugador1)
            this.darPuntosAPerdedor(jugadorActual.jugadorSiguiente, puntosJugador2)
        } else {
            this.darPuntosAGanador(jugadorActual.jugadorSiguiente, puntosJugador2)
            this.darPuntosAPerdedor(jugadorActual, puntosJugador1)
        }
    }

    override fun activarExclusividad(): Exclusividad {
        return ExclusividadX4()
    }

}