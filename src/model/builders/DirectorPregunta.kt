package model.builders

import model.data.OpcionSerializada
import model.data.PreguntaSerializada

public class DirectorPregunta {
    var tipoPuntaje: String? = null
    var enunciado: String? = null
    var opciones: List<OpcionSerializada?>? = null

    fun DirectorPregunta(tipoPuntaje: String?, enunciado: String?, opciones: List<OpcionSerializada?>?) {
        this.tipoPuntaje = tipoPuntaje
        this.enunciado = enunciado
        this.opciones = opciones
    }

    fun DirectorPregunta(preguntaSerializada: PreguntaSerializada) {
        this(preguntaSerializada.getPuntajeType(), preguntaSerializada.getEnunciado(), preguntaSerializada.getOptions())
    }

    fun asignar(builder: Builder) {
        builder.setOpciones(opciones)
        builder.asignarComportamiento(tipoPuntaje)
        builder.setEnunciado(enunciado)
    }
}