package model

import model.comportamientos.Comportamiento
import model.comportamientos.ComportamientoConExclusividad
import model.comportamientos.ComportamientoConMultiplicador
import model.data.OpcionSerializada
import model.modificadores.Exclusividad
import model.modificadores.Multiplicador

public class Pregunta {
    var enunciado: String? = null
    private var opciones: List<Opcion>? = null
    private var comportamiento: Comportamiento? = null
    var siguientePregunta: Pregunta? = null


    constructor(enunciado: String?, comportamiento: Comportamiento?){
        this.comportamiento = comportamiento
        this.enunciado = enunciado
    }

    constructor(enunciado: String?, comportamiento: Comportamiento?, opciones: List<OpcionSerializada?>?){
        Pregunta(enunciado, comportamiento)
        this.opciones = opciones as List<Opcion>
    }

    val tipoPregunta: String?
        get() = comportamiento?.tipoPregunta

    fun obtenerPuntaje(opcionesElegidasPorElJugador: List<Opcion>): Int {
        return comportamiento?.obtenerPuntaje(opcionesElegidasPorElJugador)!!
    }

    @JvmName("getSiguientePregunta1")
    fun getSiguientePregunta(): Pregunta? {
        return siguientePregunta
    }

    @JvmName("setSiguientePregunta1")
    fun setSiguientePregunta(siguientePregunta: Pregunta?) {
        this.siguientePregunta = siguientePregunta
    }

    @JvmName("getTipoPregunta1")
    fun getTipoPregunta(): String? {
        return comportamiento?.tipoPregunta
    }

    fun obtenerPuntaje(opcionesDeJugador: List<Opcion?>?, multiplicador: Multiplicador): Int {
        return multiplicador.modificarPuntos(comportamiento!!.obtenerPuntaje(opcionesDeJugador as List<Opcion>))
    }

    fun agregarMultiplicadorAJugador(jugador: Jugador?, multiplicador: Multiplicador?) {
        (comportamiento as ComportamientoConMultiplicador).agregarMultiplicadorAJugador(jugador, multiplicador)
    }

    fun activarExclusividad(exclusividad: Exclusividad?): Exclusividad? {
        return (comportamiento as ComportamientoConExclusividad).activarExclusividad(exclusividad)
    }
}
