package model.builders

import model.comportamientos.Comportamiento
import model.data.OpcionSerializada
import model.excepciones.DiferenteTipoPreguntaException
import java.util.ArrayList
import java.util.function.Consumer

class OrderedChoiceBuilder : Builder {
    lateinit var comportamiento: Comportamiento
    override lateinit var textoPregunta: String
    private var opciones: ArrayList<OpcionConjunto> = ArrayList<OpcionConjunto>()

    override fun asignarComportamiento(tipoPuntaje: String?) {
        if (tipoPuntaje != "Clasico") throw DiferenteTipoPreguntaException()
        comportamiento = ComportamientoOrderedChoice()
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