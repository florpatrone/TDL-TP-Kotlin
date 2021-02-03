package model.builders

import model.Opcion
import model.data.OpcionSerializada
import model.Pregunta

interface Builder {
    abstract var enunciado: String?
    abstract var opciones: List<OpcionSerializada?>?

    fun asignarComportamiento(tipoPuntaje: String?)

    fun construirPregunta(): Pregunta?
}
