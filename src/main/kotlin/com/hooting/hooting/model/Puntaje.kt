package com.Hoot.hoot.model

abstract class Puntaje {
    var puntajeAcumulado = 0
    var factor = 1
    abstract fun accionCorrecta()
    abstract fun accionIncorrecta()
    internal abstract fun getPuntajeAcumulado(): Int

}
