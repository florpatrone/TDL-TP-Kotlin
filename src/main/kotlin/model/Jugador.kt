package model

import model.modificadores.Multiplicador
import model.modificadores.MultiplicadorBasico
import java.util.*

class Jugador(val nombre: String) {
    var puntos = 0
    var multiplicadorClase: Multiplicador
    var respuestasElegidas: ArrayList<Opcion>
    lateinit var jugadorSiguiente: Jugador

    fun elegirOpciones(respuestasElegidas: ArrayList<Opcion>) {
        this.respuestasElegidas = respuestasElegidas
    }


    fun ganarPuntaje(puntaje: Int) {
        puntos += multiplicadorClase.modificarPuntos(puntaje)
        multiplicadorClase = MultiplicadorBasico()
    }

    fun procesarPregunta(pregunta: Pregunta, respuestas: List<Opcion?>?) {
        ganarPuntaje(pregunta.obtenerPuntaje(respuestas as List<Opcion>))
    }

    fun elegirRespuestasAPreguntaActual(respuestasElegidas: ArrayList<Opcion>) {
        this.respuestasElegidas = respuestasElegidas
    }

    init {
        respuestasElegidas = ArrayList()
        multiplicadorClase = MultiplicadorBasico()
    }
}
