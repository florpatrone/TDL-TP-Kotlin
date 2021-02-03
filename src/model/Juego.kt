package model

import model.modificadores.Exclusividad
import model.modificadores.MultiplicadorX2
import model.modificadores.MultiplicadorX3
import model.modificadores.SinExclusividad
import java.util.ArrayList

class Juego : Observable {
    private var jugadorInicial: Jugador? = null
    var jugadorActual: Jugador? = null
        private set
    var preguntaActual: Pregunta
        private set
    var exclusividadActual: Exclusividad? = null
    private val observers: ArrayList<Observer>
    fun empezarJuego(nombreJugador1: String?, nombreJugador2: String?) {
        val jugador1 = Jugador(nombreJugador1!!)
        val jugador2 = Jugador(nombreJugador2!!)
        jugador1.jugadorSiguiente = jugador2
        jugador2.jugadorSiguiente = jugador1
        jugadorInicial = jugador1
        jugadorActual = jugadorInicial
        exclusividadActual = SinExclusividad()
        notifyObservers()
    }

    private fun elegirRespuestasAPreguntaActual(respuestasElegidas: ArrayList<Opcion>): Jugador? {
        jugadorActual!!.elegirRespuestasAPreguntaActual(respuestasElegidas)
        return jugadorActual!!.jugadorSiguiente
    }

    fun siguienteTurno(respuestasElegidas: ArrayList<Opcion>) {
        jugadorActual = elegirRespuestasAPreguntaActual(respuestasElegidas)
        if (jugadorActual === jugadorInicial) {
            exclusividadActual?.definirPuntosJugadoresEnPregunta(preguntaActual, jugadorActual)
            preguntaActual = preguntaActual.siguientePregunta!!
            exclusividadActual = SinExclusividad()
        }
        notifyObservers()
    }

    fun activarExclusividad() {
        exclusividadActual = preguntaActual.activarExclusividad(exclusividadActual)
    }

    fun activarMultiplicadorX2() {
        preguntaActual.agregarMultiplicadorAJugador(jugadorActual, MultiplicadorX2())
    }

    fun activarMultiplicadorX3() {
        preguntaActual.agregarMultiplicadorAJugador(jugadorActual, MultiplicadorX3())
    }

    val tipoPregunta: String?
        get() = preguntaActual.tipoPregunta

    override fun addObserver(observer: Observer?) {
        observers.add(observer!!)
    }

    override fun notifyObservers() {
        observers.forEach(Observer::update)
    }

    val ganador: Jugador?
        get() = if (jugadorActual!!.puntos > jugadorActual!!.jugadorSiguiente!!.puntos) jugadorActual else jugadorActual!!.jugadorSiguiente

    init {
        preguntaActual = Parser().parsear()
        observers = ArrayList<Observer>()
    }
}