package com.hooting.hooting.model

import com.hooting.hooting.data.Pregunta
import com.hooting.hooting.data.Respuesta

class ComparadorRespuestas {

    fun compararRespuestas(preguntaActual: Pregunta, respuestasElegidas: ArrayList<Respuesta>): Int {

        var cantidadIncorrectas: Int = 0
        var cantidadCorrecta: Int = 0
        respuestasElegidas.forEach{ respuesta ->
            if(!respuesta.isTrue) {
                cantidadIncorrectas++
            }
            else cantidadCorrecta++
        }

        if(preguntaActual.cantidadCorrecta == cantidadCorrecta && (cantidadIncorrectas == 0)) {
            return 1
        }
        else return -1

    }
}