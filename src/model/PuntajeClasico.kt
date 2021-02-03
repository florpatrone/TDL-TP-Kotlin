package model

class PuntajeClasico : Puntaje() {
    override fun accionCorrecta() {
        puntajeAcumulado = factor
    }

    override fun accionIncorrecta() {
        puntajeAcumulado = 0
        factor = 0
    }

}
