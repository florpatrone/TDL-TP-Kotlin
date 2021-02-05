package model

class PuntajePenalidad : Puntaje() {
    override fun accionCorrecta() {
        puntajeAcumulado += factor
    }

    override fun accionIncorrecta() {
        puntajeAcumulado -= factor
    }

    override fun getPuntajeAcumulado(): Int {
        return puntajeAcumulado
    }
}
