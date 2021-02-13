package model

class PuntajeParcial : Puntaje() {
    override fun accionCorrecta() {
        puntajeAcumulado += factor
    }

    override fun accionIncorrecta() {
        puntajeAcumulado = 0
        factor = 0
    }

    override fun getPuntajeAcumulado(): Int {
        return puntajeAcumulado
    }

}