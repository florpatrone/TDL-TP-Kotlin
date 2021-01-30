package model

import comportamientos.Comportamiento
import comportamientos.ComportamientoConMultiplicador
import model.modificadores.Multiplicador

class Pregunta(enunciado: String?, comportamiento: Comportamiento) {
    val enunciado: String?
    private var opciones: List<Opcion>? = null
    private val comportamiento: Comportamiento
    var siguientePregunta: Pregunta? = null

    constructor(enunciado: String?, comportamiento: Comportamiento, opciones: List<Opcion>?) : this(
        enunciado,
        comportamiento
    ) {
        this.opciones = opciones
    }

    fun getOpciones(): List<Opcion>? {
        return opciones
    }

    fun setOpciones(opciones: List<Opcion>?) {
        this.opciones = opciones
    }

    val tipoPregunta: String?
        get() = comportamiento.tipoPregunta

    fun obtenerPuntaje(opcionesElegidasPorElJugador: List<Opcion?>?): Int {
        return comportamiento.obtenerPuntaje(opcionesElegidasPorElJugador)
    }

    fun obtenerPuntaje(opcionesDeJugador: List<Opcion?>?, multiplicador: Multiplicador): Int {
        return multiplicador.modificarPuntos(comportamiento.obtenerPuntaje(opcionesDeJugador))
    }

    fun agregarMultiplicadorAJugador(jugador: Jugador?, multiplicador: Multiplicador?) {
        (comportamiento as ComportamientoConMultiplicador).agregarMultiplicadorAJugador(jugador, multiplicador)
    }

    init {
        this.comportamiento = comportamiento
        this.enunciado = enunciado
    }
}
