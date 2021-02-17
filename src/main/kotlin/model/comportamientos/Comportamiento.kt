package model.comportamientos

import java.util.*
import model.*
import model.data.Respuesta

abstract class Comportamiento {
    fun correcto(puntaje: Puntaje) {
        puntaje.accionCorrecta()
    }

    fun incorrecto(puntaje: Puntaje) {
        puntaje.accionIncorrecta()
    }

    private fun verificarOpciones(opcionesElegidasPorElJugador: List<Opcion>): List<Respuesta> {
        val respuestas: ArrayList<Respuesta> = ArrayList<Respuesta>()
        for (opcion in opcionesElegidasPorElJugador) {
            respuestas.add(opcion.convertirEnRespuesta())
        }
        return respuestas
    }

    fun obtenerPuntaje(opcionesElegidasPorElJugador: List<Opcion>): Int {
        val respuestas: List<Respuesta> = verificarOpciones(opcionesElegidasPorElJugador)
        val puntaje: Puntaje = crearPuntaje()
        for (respuesta in respuestas) {
            respuesta.aplicarComportamiento(this, puntaje)
        }
        return puntaje.getPuntajeAcumulado()
    }

    abstract val tipoPregunta: String

    protected abstract fun crearPuntaje(): Puntaje
}
