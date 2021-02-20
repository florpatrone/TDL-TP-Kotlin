package com.Hoot.hoot.model

import com.hooting.hooting.data.Pregunta
import com.hooting.hooting.data.Respuesta
import com.hooting.hooting.web.PreguntaRestController
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.ArrayList

class Juego : Observable {
    lateinit var jugadorInicial: Jugador
    lateinit var jugadorActual: Jugador
    var preguntaActual: Pregunta
    var preguntas: ArrayList<Pregunta>
    lateinit var iteradorPreguntas: Iterator<Pregunta>
    private val observers: ArrayList<Observer>
    var preguntaRestController: PreguntaRestController = PreguntaRestController()

    fun traerPreguntas() {
        //preguntas = preguntaRestController.list() as ArrayList<Pregunta>
        iteradorPreguntas = preguntas.listIterator()
    }

    fun empezarJuego(nombreJugador1: String, nombreJugador2: String) {
        val jugador1 = Jugador(nombreJugador1)
        val jugador2 = Jugador(nombreJugador2)
        jugador1.jugadorSiguiente = jugador2
        jugador2.jugadorSiguiente = jugador1
        jugadorInicial = jugador1
        jugadorActual = jugadorInicial
        GlobalScope.launch {
            traerPreguntas()
        }
        notifyObservers()
    }

    fun agregarMultiplicador(factor: Int) {
        jugadorActual.agregarMultiplicador(factor)
    }

    private fun elegirRespuestasAPreguntaActual(respuestasElegidas: ArrayList<Respuesta>): Jugador {

        var respuestasIncorrectas: Int = 0
        respuestasElegidas.forEach {
            respuesta -> if(respuesta.isTrue == false) {
                respuestasIncorrectas++
            }
        }
        if (respuestasIncorrectas > 0) {
            jugadorActual.sumarPuntos(-1)
        }
        else jugadorActual.sumarPuntos(1)

        return jugadorActual.jugadorSiguiente
    }

    fun siguienteTurno(respuestasElegidas: ArrayList<Respuesta>) {
        jugadorActual = elegirRespuestasAPreguntaActual(respuestasElegidas)
        if (jugadorActual === jugadorInicial) {
            if (iteradorPreguntas.hasNext()) {
                preguntaActual = iteradorPreguntas.next()
            }
        }
        notifyObservers()
    }


    fun elJuegoSigue(): Boolean {
        if (iteradorPreguntas.hasNext()) {
            return true
        }
        else return false
    }

    override fun addObserver(observer: Observer?) {
        observers.add(observer!!)
    }

    override fun notifyObservers() {
        observers.forEach(Observer::update)
    }

    val ganador: Jugador?
        get() = if (jugadorActual.puntaje.puntos > jugadorActual.jugadorSiguiente.puntaje.puntos) {
            jugadorActual
        }
            else if (jugadorActual.puntaje.puntos == jugadorActual.jugadorSiguiente.puntaje.puntos) {
            null
        }
            else jugadorActual.jugadorSiguiente

    init {
        preguntaActual = Pregunta()
        preguntas = ArrayList<Pregunta>()
        observers = ArrayList<Observer>()
    }
}