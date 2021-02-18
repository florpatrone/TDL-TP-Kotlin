package com.Hoot.hoot.model

import com.hooting.hooting.data.Pregunta
import com.hooting.hooting.data.Respuesta
import java.util.ArrayList

class Juego : Observable {
    lateinit var jugadorInicial: Jugador
    lateinit var jugadorActual: Jugador
    var preguntaActual: Pregunta
    var preguntas: ArrayList<Pregunta>
    private val observers: ArrayList<Observer>


    fun empezarJuego(nombreJugador1: String, nombreJugador2: String) {
        val jugador1 = Jugador(nombreJugador1)
        val jugador2 = Jugador(nombreJugador2)
        jugador1.jugadorSiguiente = jugador2
        jugador2.jugadorSiguiente = jugador1
        jugadorInicial = jugador1
        jugadorActual = jugadorInicial
        notifyObservers()
    }

    private fun elegirRespuestasAPreguntaActual(respuestasElegidas: ArrayList<Respuesta>): Jugador {
        jugadorActual.elegirRespuestasAPreguntaActual(respuestasElegidas)
        return jugadorActual.jugadorSiguiente
    }

    fun siguienteTurno(respuestasElegidas: ArrayList<Respuesta>) {
        jugadorActual = elegirRespuestasAPreguntaActual(respuestasElegidas)
        if (jugadorActual === jugadorInicial) {
            //preguntaActual = preguntaActual.siguientePregunta
        }
        notifyObservers()
    }

    val tipoPregunta: String?
        get() = preguntaActual.tipoPregunta

    override fun addObserver(observer: Observer?) {
        observers.add(observer!!)
    }

    override fun notifyObservers() {
        observers.forEach(Observer::update)
    }

    val ganador: Jugador
        get() = if (jugadorActual.puntos > jugadorActual.jugadorSiguiente.puntos) jugadorActual else jugadorActual.jugadorSiguiente

    init {
        preguntaActual = Pregunta()
        preguntas = ArrayList<Pregunta>()
        observers = ArrayList<Observer>()
    }
}