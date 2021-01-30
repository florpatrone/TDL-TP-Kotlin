package model.builders

import model.Pregunta

interface Builder {
    fun asignarComportamiento(tipoPuntaje: String?)

    fun setEnunciado(enunciado: String?)

    fun setOpciones(opciones: List<OpcionSerializada?>?)

    fun construirPregunta(): Pregunta?
}
