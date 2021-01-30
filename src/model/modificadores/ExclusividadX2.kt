package model.modificadores

class ExclusividadX2 : Exclusividad {
    private val valorExclusividad = 2
    fun darPuntosAGanador(jugador: Jugador, puntosGanados: Int) {
        jugador.ganarPuntaje(valorExclusividad * puntosGanados)
    }

    fun darPuntosAPerdedor(jugador: Jugador, puntosGanados: Int) {
        jugador.ganarPuntaje(puntosGanados)
    }

    override fun activarExclusividad(): Exclusividad {
        return ExclusividadX4()
    }

    fun definirPuntosJugadoresEnPregunta(pregunta: Pregunta, jugadorActual: Jugador) {
        val puntosJugador1: Int = pregunta.obtenerPuntaje(jugadorActual.getRespuestasElegidas())
        val puntosJugador2: Int = pregunta.obtenerPuntaje(jugadorActual.getJugadorSiguiente().getRespuestasElegidas())
        if (puntosJugador1 == puntosJugador2) return
        if (puntosJugador1 > puntosJugador2) {
            this.darPuntosAGanador(jugadorActual, puntosJugador1)
            this.darPuntosAPerdedor(jugadorActual.getJugadorSiguiente(), puntosJugador2)
        } else {
            this.darPuntosAGanador(jugadorActual.getJugadorSiguiente(), puntosJugador2)
            this.darPuntosAPerdedor(jugadorActual, puntosJugador1)
        }
    }
}