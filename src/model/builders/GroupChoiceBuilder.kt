package model.builders

import java.util.ArrayList
import java.util.function.Consumer

class GroupChoiceBuilder implements Builder {
    var comportamiento: Comportamiento? = null
    val textoPregunta: String? = null
    val opciones: List<Opcion>? = null

    fun asignarComportamiento(tipoPuntaje: String) {
        if (tipoPuntaje != "Clasico") throw DiferenteTipoPreguntaException()
        comportamiento = ComportamientoGroupChoice()
    }

    fun setEnunciado(enunciado: String) {
        this.textoPregunta = enunciado
    }

    fun setOpciones(opciones: List<OpcionSerializada?>) {
        this.opciones = ArrayList<Opcion>()
        opciones.forEach(Consumer<OpcionSerializada> { opcionSerializada: OpcionSerializada ->
            this.opciones.add(
                OpcionConjunto(opcionSerializada.getClave(), opcionSerializada.getTexto())
            )
        })
    }

    fun construirPregunta(): Pregunta? {
        return Pregunta(textoPregunta, comportamiento, opciones)
    }