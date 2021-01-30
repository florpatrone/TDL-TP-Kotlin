package model

import comportamientos.Comportamiento

abstract class Respuesta(protected var textoRespuesta: String) {
    abstract fun aplicarComportamiento(comportamiento: Comportamiento?, puntaje: Puntaje?)
}
