package model


import model.data.Respuesta
import java.util.*

class Jugador(val nombre: String) {
    var puntos = 0
    var respuestasElegidas: ArrayList<Respuesta>
    lateinit var jugadorSiguiente: Jugador


    fun ganarPuntaje(puntaje: Int) {
        puntos += puntaje
    }

    fun elegirRespuestasAPreguntaActual(respuestasElegidas: ArrayList<Respuesta>) {
        this.respuestasElegidas = respuestasElegidas
    }

    init {
        respuestasElegidas = ArrayList()
    }
}
