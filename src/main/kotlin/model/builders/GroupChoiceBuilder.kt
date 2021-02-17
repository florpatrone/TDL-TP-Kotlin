package model.builders

import model.comportamientos.Comportamiento
import model.data.OpcionSerializada
import model.excepciones.DiferenteTipoPreguntaException
import java.util.ArrayList
import java.util.function.Consumer

class GroupChoiceBuilder : Builder {
    lateinit var comportamiento: Comportamiento
    override lateinit var textoPregunta: String
    private var opciones: ArrayList<OpcionConjunto>

    constructor() {
        opciones = ArrayList<OpcionConjunto>()
    }

    override fun asignarComportamiento(tipoPuntaje: String?) {
        if (tipoPuntaje != "Clasico") throw DiferenteTipoPreguntaException()
        comportamiento = ComportamientoGroupChoice()
    }

    override fun construirPregunta(): Pregunta {
        return Pregunta(textoPregunta, comportamiento, opciones)
    }

    override fun setOpciones(opciones: List<OpcionSerializada>) {
        opciones.forEach(Consumer { opcionSerializada: OpcionSerializada ->
            this.opciones.add(
                    OpcionConjunto(opcionSerializada.clave, opcionSerializada.texto)
            )
        })
    }
}
