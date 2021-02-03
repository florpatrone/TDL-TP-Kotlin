package model

import model.comportamientos.Comportamiento
import model.comportamientos.ComportamientoConExclusividad
import model.comportamientos.ComportamientoConMultiplicador
import model.modificadores.Exclusividad
import model.modificadores.Multiplicador

class Pregunta(val enunciado: String?, private val comportamiento: Comportamiento) {
    var opciones: List<Opcion>? = null
    var siguientePregunta: Pregunta? = null

    constructor(enunciado: String?, comportamiento: Comportamiento, opciones: List<Opcion>?) : this(
        enunciado,
        comportamiento
    ) {
        this.opciones = opciones
    }

    val tipoPregunta: String?
        get() = comportamiento.tipoPregunta

    fun obtenerPuntaje(opcionesElegidasPorElJugador: List<Opcion?>?): Int {
        return comportamiento.obtenerPuntaje(opcionesElegidasPorElJugador as List<Opcion>)
    }

    @JvmName("getSiguientePregunta1")
    fun getSiguientePregunta(): Pregunta? {
        return siguientePregunta
    }

    @JvmName("getTipoPregunta1")
    fun getTipoPregunta(): String? {
        return comportamiento.tipoPregunta
    }

    fun obtenerPuntaje(opcionesDeJugador: List<Opcion?>?, multiplicador: Multiplicador): Int {
        return multiplicador.modificarPuntos(comportamiento.obtenerPuntaje(opcionesDeJugador as List<Opcion>))
    }

    fun agregarMultiplicadorAJugador(jugador: Jugador?, multiplicador: Multiplicador?) {
        (comportamiento as ComportamientoConMultiplicador).agregarMultiplicadorAJugador(jugador, multiplicador)
    }

    fun activarExclusividad(exclusividad: Exclusividad?): Exclusividad? {
        return (comportamiento as ComportamientoConExclusividad).activarExclusividad(exclusividad)
    }
}
