package model

import java.util.ArrayList

class Juego {

    private var jugadorInicial: Jugador? = null
    var jugadorActual: Jugador? = null
    private var preguntaActual: Pregunta? = null

    fun empezarJuego(nombreJugador1: String, nombreJugador2: String) {
        val jugador1 = Jugador(nombreJugador1)
        val jugador2 = Jugador(nombreJugador2)
        jugador1.jugadorSiguiente = jugador2
        jugador2.jugadorSiguiente = jugador1
        jugadorInicial = jugador1
        jugadorActual = jugadorInicial
    }

    private fun elegirRespuestasAPreguntaActual(respuestasElegidas: ArrayList<Opcion>): Jugador? {
        jugadorActual?.elegirRespuestasAPreguntaActual(respuestasElegidas)
        return jugadorActual?.jugadorSiguiente
    }

    fun siguienteTurno(respuestasElegidas: ArrayList<Opcion>) {
        jugadorActual = elegirRespuestasAPreguntaActual(respuestasElegidas)
        if (jugadorActual === jugadorInicial) {
            preguntaActual = preguntaActual?.siguientePregunta
        }
    }

    fun getPreguntaActual(): Pregunta? {
        return preguntaActual
    }

    val tipoPregunta: String?
        get() = preguntaActual?.tipoPregunta

    val ganador: Jugador?
        get() = if (jugadorActual?.puntos!! > jugadorActual?.jugadorSiguiente?.puntos!!) jugadorActual else jugadorActual!!.jugadorSiguiente

}