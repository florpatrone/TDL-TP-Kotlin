package model.modificadores

import model.Jugador

class SinExclusividad : Exclusividad {
    override fun activarExclusividad(): Exclusividad {
        return ExclusividadX2()
    }

    override fun darPuntosAGanador(jugador: Jugador, puntosGanados: Int) {
        jugador.ganarPuntaje(puntosGanados)
    }

    override fun darPuntosAPerdedor(jugador: Jugador, puntosGanados: Int) {
        jugador.ganarPuntaje(puntosGanados)
    }

    override fun definirPuntosJugadoresEnPregunta(pregunta: Pregunta, jugadorActual: Jugador) {
        val puntosJugador1: Int = pregunta.obtenerPuntaje(jugadorActual.respuestasElegidas)
        val puntosJugador2: Int = pregunta.obtenerPuntaje(jugadorActual.jugadorSiguiente.respuestasElegidas)
        this.darPuntosAGanador(jugadorActual, puntosJugador1)
        this.darPuntosAGanador(jugadorActual.jugadorSiguiente, puntosJugador2)
    }
}