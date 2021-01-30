package model

import java.util.*
import model.modificadores.Multiplicador

class Jugador(val nombre: String) {

    var puntos = 0
    private var respuestasElegidas: ArrayList<Opcion>
    var jugadorSiguiente: Jugador? = null
    private var multiplicadorClase: Multiplicador? = null

    fun elegirOpciones(respuestasElegidas: ArrayList<Opcion>) {
        this.respuestasElegidas = respuestasElegidas
    }

    fun setMultiplicador(multiplicadorClase: Multiplicador?) {
        this.multiplicadorClase = multiplicadorClase
    }

    fun ganarPuntaje(puntaje: Int) {
        puntos += puntaje
    }

    fun procesarPregunta(pregunta: Pregunta, respuestas: List<Opcion?>?) {
        ganarPuntaje(pregunta.obtenerPuntaje(respuestas))
    }

    fun elegirRespuestasAPreguntaActual(respuestasElegidas: ArrayList<Opcion>) {
        this.respuestasElegidas = respuestasElegidas
    }

    fun getRespuestasElegidas(): ArrayList<Opcion> {
        return respuestasElegidas
    }

    init {
        respuestasElegidas = ArrayList<Opcion>()
    }


}
