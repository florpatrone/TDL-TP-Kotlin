package model

import java.util.ArrayList

class Juego {

    private var jugadorInicial: Jugador? = null
    var jugadorActual: Jugador? = null
    private var preguntaActual: Pregunta

    fun empezarJuego(nombreJugador1: String?, nombreJugador2: String?) {
        val jugador1 = Jugador(nombreJugador1)
        val jugador2 = Jugador(nombreJugador2)
        jugador1.setJugadorSiguiente(jugador2)
        jugador2.setJugadorSiguiente(jugador1)
        jugadorInicial = jugador1
        jugadorActual = jugadorInicial
    }

    private fun elegirRespuestasAPreguntaActual(respuestasElegidas: ArrayList<Opcion>): Jugador {
        jugadorActual.elegirRespuestasAPreguntaActual(respuestasElegidas)
        return jugadorActual.getJugadorSiguiente()
    }

    fun siguienteTurno(respuestasElegidas: ArrayList<Opcion>) {
        jugadorActual = elegirRespuestasAPreguntaActual(respuestasElegidas)
        if (jugadorActual === jugadorInicial) {
            preguntaActual = preguntaActual.getSiguientePregunta()
        }
    }

    fun getPreguntaActual(): Pregunta {
        return preguntaActual
    }

    val tipoPregunta: String
        get() = preguntaActual.getTipoPregunta()

    val ganador: Jugador?
        get() = if (jugadorActual.getPuntos() > jugadorActual.getJugadorSiguiente().getPuntos()) jugadorActual else jugadorActual.getJugadorSiguiente()

}