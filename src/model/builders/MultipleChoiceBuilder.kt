package model.builders

import model.Opcion
import model.Pregunta
import model.comportamientos.Comportamiento
import model.comportamientos.ComportamientoMultipleChoiceClasico
import model.comportamientos.ComportamientoMultipleChoicePenalidad
import model.data.OpcionSerializada
import model.excepciones.DiferenteTipoPreguntaException
import java.util.ArrayList
import java.util.function.Consumer

class MultipleChoiceBuilder : Builder {
    var comportamiento: Comportamiento? = null
    private var textoPregunta: String? = null
    private var opciones: MutableList<Opcion>? = null
    override fun asignarComportamiento(tipoPuntaje: String?) {
        when (tipoPuntaje) {
            "Clasico" -> comportamiento = ComportamientoMultipleChoiceClasico()
            //"Parcial" -> comportamiento = ComportamientoMultipleChoiceParcial()
            "Penalidad" -> comportamiento = ComportamientoMultipleChoicePenalidad()
            else -> throw DiferenteTipoPreguntaException()
        }
    }

    override fun setEnunciado(enunciado: String?) {
        textoPregunta = enunciado
    }

    fun setOpciones(opciones: List<OpcionSerializada?>) {
        this.opciones = ArrayList<Opcion>()
        opciones.forEach(Consumer<OpcionSerializada> { opcionSerializada: OpcionSerializada ->
            this.opciones!!.add(
                Opcion(opcionSerializada.getClave(), opcionSerializada.getTexto())
            )
        })
    }

    override fun construirPregunta(): Pregunta {
        return Pregunta(textoPregunta, comportamiento, opciones)
    }
}