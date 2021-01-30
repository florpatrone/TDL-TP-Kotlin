package model

import java.util.*

class Jugador(val nombre: String) {

    var puntos = 0
    private var respuestasElegidas: ArrayList<Opcion>
    var jugadorSiguiente: Jugador? = null

    fun elegirOpciones(respuestasElegidas: ArrayList<Opcion>) {
        this.respuestasElegidas = respuestasElegidas
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
