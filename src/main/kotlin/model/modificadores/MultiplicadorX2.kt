package model.modificadores

class MultiplicadorX2 : Multiplicador {
    private val valorMultiplicador = 2

    override fun aplicarMultiplicador(puntajeBase: Int): Int {
        return 0
    }

    override fun modificarPuntos(puntos: Int): Int {
        return valorMultiplicador * puntos
    }
}