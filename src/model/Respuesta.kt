package model

abstract class Respuesta(protected var textoRespuesta: String) {
    abstract fun aplicarComportamiento(comportamiento: Comportamiento?, puntaje: Puntaje?)
}
