package model.modificadores

class MultiplicadorBasico : Multiplicador {
    override fun aplicarMultiplicador(puntajeBase: Int): Int {
        return 0
    }

    override fun modificarPuntos(puntos: Int): Int {
        return puntos
    }
}