package model

import model.comportamientos.Comportamiento

class RespuestaIncorrecta(textoRespuesta: String?) : Respuesta(textoRespuesta!!) {
    override fun aplicarComportamiento(comportamiento: Comportamiento, puntaje: Puntaje?) {
        comportamiento.incorrecto(puntaje)
    }
}
