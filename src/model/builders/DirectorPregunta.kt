package model.builders

import model.data.OpcionSerializada
import model.data.PreguntaSerializada

class DirectorPregunta(var tipoPuntaje: String?, var enunciado: String, var opciones: List<OpcionSerializada?>?) {
    constructor(preguntaSerializada: PreguntaSerializada) : this(
        preguntaSerializada.puntajeType,
        preguntaSerializada.enunciado,
        preguntaSerializada.options
    ) {

    }

    @Suppress("UNCHECKED_CAST")
    fun asignar(builder: Builder) {
        builder.setOpciones(opciones as List<OpcionSerializada>)
        builder.asignarComportamiento(tipoPuntaje)
        builder.textoPregunta = enunciado
    }
}