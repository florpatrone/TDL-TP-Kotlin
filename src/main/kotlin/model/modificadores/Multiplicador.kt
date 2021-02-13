package model.modificadores

interface Multiplicador {
    fun aplicarMultiplicador(puntajeBase: Int): Int
    fun modificarPuntos(puntos: Int): Int
}