package model.builders

import model.Pregunta
import model.data.OpcionSerializada

interface Builder {
    fun asignarComportamiento(tipoPuntaje: String?)

    fun construirPregunta(): Pregunta?

    fun setEnunciado(enunciado: String)

    fun setOpciones(opciones: List<OpcionSerializada>)
}
