package model.modificadores

class MultiplicadorX3 : Multiplicador {
    private val valorMultiplicador = 3
    override fun aplicarMultiplicador(puntajeBase: Int): Int {
        return 0
    }

    override fun modificarPuntos(puntos: Int): Int {
        return valorMultiplicador * puntos
    }
}