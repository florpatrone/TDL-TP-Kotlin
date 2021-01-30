package model

abstract class Puntaje {
    var puntajeAcumulado = 0
    var factor = 1
    abstract fun accionCorrecta()
    abstract fun accionIncorrecta()
}
