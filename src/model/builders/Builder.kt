package model.builders

import model.Pregunta
import model.data.OpcionSerializada

interface Builder {

    abstract var textoPregunta: String

    fun asignarComportamiento(tipoPuntaje: String?)

    fun construirPregunta(): Pregunta?

    fun setOpciones(opciones: List<OpcionSerializada>)
}
