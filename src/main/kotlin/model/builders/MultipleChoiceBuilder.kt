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
    lateinit var comportamiento: Comportamiento
    override lateinit var textoPregunta: String
    private var opciones: ArrayList<OpcionConjunto> = ArrayList<OpcionConjunto>()

    override fun asignarComportamiento(tipoPuntaje: String?) {
        comportamiento = when (tipoPuntaje) {
            "Clasico" -> ComportamientoMultipleChoiceClasico()
            "Parcial" -> ComportamientoMultipleChoiceParcial()
            "Penalidad" -> ComportamientoMultipleChoicePenalidad()
            else -> throw DiferenteTipoPreguntaException()
        }
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