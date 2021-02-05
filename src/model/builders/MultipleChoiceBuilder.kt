package model.builders

import model.OpcionConjunto
import model.Pregunta
import model.comportamientos.Comportamiento
import model.comportamientos.ComportamientoMultipleChoiceClasico
import model.comportamientos.ComportamientoMultipleChoiceParcial
import model.comportamientos.ComportamientoMultipleChoicePenalidad
import model.data.OpcionSerializada
import model.excepciones.DiferenteTipoPreguntaException
import java.util.ArrayList
import java.util.function.Consumer

class MultipleChoiceBuilder : Builder {
    var comportamiento: Comportamiento? = null
    private var textoPregunta: String? = null
    private var opciones: ArrayList<OpcionConjunto>

    constructor() {
        opciones = ArrayList<OpcionConjunto>()
    }

    override fun asignarComportamiento(tipoPuntaje: String?) {
        when (tipoPuntaje) {
            "Clasico" -> comportamiento = ComportamientoMultipleChoiceClasico()
            "Parcial" -> comportamiento = ComportamientoMultipleChoiceParcial()
            "Penalidad" -> comportamiento = ComportamientoMultipleChoicePenalidad()
            else -> throw DiferenteTipoPreguntaException()
        }
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