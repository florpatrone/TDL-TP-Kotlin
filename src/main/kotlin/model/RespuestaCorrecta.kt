package model

import model.comportamientos.Comportamiento

class RespuestaCorrecta(textoRespuesta: String?) : Respuesta(textoRespuesta) {
    override fun aplicarComportamiento(comportamiento: Comportamiento?, puntaje: Puntaje) {
        comportamiento?.correcto(puntaje)
    }

}
