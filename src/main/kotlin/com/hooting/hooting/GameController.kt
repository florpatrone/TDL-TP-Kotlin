package com.hooting.hooting

import com.Hoot.hoot.model.Juego
import com.Hoot.hoot.model.Jugador
import com.hooting.hooting.data.Respuesta

class GameController (var juego: Juego) {



    fun siguienteTurno(respuestasElegidas: ArrayList<Respuesta>): Jugador? {
        if(juego.elJuegoSigue()) {
            juego.siguienteTurno(respuestasElegidas)
            return null
        }
        else return juego.ganador
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



}