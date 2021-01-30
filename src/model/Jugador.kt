package model

import model.modificadores.Multiplicador
import model.modificadores.MultiplicadorBasico
import java.util.*

class Jugador(val nombre: String) {
    var puntos = 0
        private set
    private var multiplicadorClase: Multiplicador
    var respuestasElegidas: ArrayList<Opcion>
        private set
    var jugadorSiguiente: Jugador? = null

    fun elegirOpciones(respuestasElegidas: ArrayList<Opcion>) {
        this.respuestasElegidas = respuestasElegidas
    }

    fun setMultiplicador(multiplicadorClase: Multiplicador) {
        this.multiplicadorClase = multiplicadorClase
    }

    fun ganarPuntaje(puntaje: Int) {
        puntos += multiplicadorClase.modificarPuntos(puntaje)
        setMultiplicador(MultiplicadorBasico())
    }

    fun procesarPregunta(pregunta: Pregunta, respuestas: List<Opcion?>?) {
        ganarPuntaje(pregunta.obtenerPuntaje(respuestas))
    }

    fun elegirRespuestasAPreguntaActual(respuestasElegidas: ArrayList<Opcion>) {
        this.respuestasElegidas = respuestasElegidas
    }

    init {
        respuestasElegidas = ArrayList()
        multiplicadorClase = MultiplicadorBasico()
    }
}
