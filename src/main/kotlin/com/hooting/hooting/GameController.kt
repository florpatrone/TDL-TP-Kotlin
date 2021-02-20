package com.hooting.hooting

import com.Hoot.hoot.model.Juego
import com.Hoot.hoot.model.Jugador
import com.hooting.hooting.data.Pregunta
import com.hooting.hooting.data.Respuesta

class GameController (var juego: Juego) {

    fun siguienteTurno(respuestasElegidas: ArrayList<Respuesta>): HashMap<Jugador, Int>? {
        if(juego.elJuegoSigue()) {
            juego.siguienteTurno(respuestasElegidas)
            return null
        }
        var puntajes: HashMap<Jugador,Int> = HashMap<Jugador,Int>()
        puntajes.put(juego.jugadorActual,juego.jugadorActual.puntaje.puntos)
        puntajes.put(juego.jugadorActual.jugadorSiguiente,juego.jugadorActual.jugadorSiguiente.puntaje.puntos)
        return puntajes
    }

    fun empezarJuego(nombre1: String, nombre2: String) {
        juego.empezarJuego(nombre1,nombre2)
    }

    fun agregarMultiplicador(factor: Int) {
        juego.jugadorActual.agregarMultiplicador(factor)
    }

    fun sumarPuntos(puntos: Int) {
        juego.jugadorActual.sumarPuntos(puntos)
    }

    fun getPreguntas(): ArrayList<Pregunta> {
        return juego.preguntas
    }

}