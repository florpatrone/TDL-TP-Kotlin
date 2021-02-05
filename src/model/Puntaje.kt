package model

abstract class Puntaje {
    var puntajeAcumulado = 0
    var factor = 1
    abstract fun accionCorrecta()
    abstract fun accionIncorrecta()

    //@JvmName("getPuntajeAcumulado1")
    internal abstract fun getPuntajeAcumulado(): Int

}
