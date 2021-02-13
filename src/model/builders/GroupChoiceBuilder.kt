package model.builders

import model.OpcionConjunto
import model.Pregunta
import model.comportamientos.Comportamiento
import model.comportamientos.ComportamientoGroupChoice
import model.data.OpcionSerializada
import model.excepciones.DiferenteTipoPreguntaException
import java.util.ArrayList
import java.util.function.Consumer

class GroupChoiceBuilder : Builder {
    var comportamiento: Comportamiento? = null
    private var textoPregunta: String? = null
    private var opciones: ArrayList<OpcionConjunto>

    constructor() {
        opciones = ArrayList<OpcionConjunto>()
    }

    override fun asignarComportamiento(tipoPuntaje: String?) {
        if (tipoPuntaje != "Clasico") throw DiferenteTipoPreguntaException()
        comportamiento = ComportamientoGroupChoice()
    }

    override fun construirPregunta(): Pregunta? {
        return Pregunta(textoPregunta, comportamiento!!, opciones)
    }

    override fun setEnunciado(enunciado: String) {
        textoPregunta = enunciado
    }

    override fun setOpciones(opciones: List<OpcionSerializada>) {
        opciones.forEach(Consumer { opcionSerializada: OpcionSerializada ->
            this.opciones.add(
                    OpcionConjunto(opcionSerializada.getClave(), opcionSerializada.getTexto())
            )
        })
    }
}
