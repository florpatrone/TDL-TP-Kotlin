package model.builders

import model.data.OpcionSerializada
import model.data.PreguntaSerializada

class DirectorPregunta(var tipoPuntaje: String?, var enunciado: String?, var opciones: List<OpcionSerializada?>?) {
    constructor(preguntaSerializada: PreguntaSerializada) : this(
        preguntaSerializada.getPuntajeType(),
        preguntaSerializada.getEnunciado(),
        preguntaSerializada.getOptions()
    ) {

    }

    @Suppress("UNCHECKED_CAST")
    fun asignar(builder: Builder) {
        builder.setOpciones(opciones as List<OpcionSerializada>)
        builder.asignarComportamiento(tipoPuntaje)
        builder.setEnunciado(enunciado!!)
    }
}