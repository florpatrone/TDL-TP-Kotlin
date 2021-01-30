package model

import model.modificadores.Exclusividad
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
        jugador1.setJugadorSiguiente(jugador2)
        jugador2.setJugadorSiguiente(jugador1)
        jugadorInicial = jugador1
        jugadorActual = jugadorInicial
        exclusividadActual = SinExclusividad()
        notifyObservers()
    }

    private fun elegirRespuestasAPreguntaActual(respuestasElegidas: ArrayList<Opcion>): Jugador {
        jugadorActual!!.elegirRespuestasAPreguntaActual(respuestasElegidas)
        return jugadorActual.getJugadorSiguiente()
    }

    fun siguienteTurno(respuestasElegidas: ArrayList<Opcion>) {
        jugadorActual = elegirRespuestasAPreguntaActual(respuestasElegidas)
        if (jugadorActual === jugadorInicial) {
            exclusividadActual.definirPuntosJugadoresEnPregunta(preguntaActual, jugadorActual)
            preguntaActual = preguntaActual.getSiguientePregunta()
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

    val tipoPregunta: String
        get() = preguntaActual.getTipoPregunta()

    fun addObserver(observer: Observer) {
        observers.add(observer)
    }

    fun notifyObservers() {
        observers.forEach(Observer::update)
    }

    val ganador: Jugador?
        get() = if (jugadorActual.getPuntos() > jugadorActual.getJugadorSiguiente().getPuntos()) jugadorActual else jugadorActual.getJugadorSiguiente()

    init {
        preguntaActual = Parser().parsear()
        observers = ArrayList<Observer>()
    }
}