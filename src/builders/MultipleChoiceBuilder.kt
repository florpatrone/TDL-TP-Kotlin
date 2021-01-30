package builders

import java.util.ArrayList
import java.util.function.Consumer

class MultipleChoiceBuilder implements Builder {
    var comportamiento: Comportamiento? = null
    val textoPregunta: String? = null
    val opciones: List<Opcion>? = null

    fun asignarComportamiento(tipoPuntaje: String?) {
        when (tipoPuntaje) {
            "Clasico" -> comportamiento = ComportamientoMultipleChoiceClasico()
            "Parcial" -> comportamiento = ComportamientoMultipleChoiceParcial()
            "Penalidad" -> comportamiento = ComportamientoMultipleChoicePenalidad()
            else -> throw DiferenteTipoPreguntaException()
        }
    }

    fun setEnunciado(enunciado: String) {
        this.textoPregunta = enunciado
    }

    fun setOpciones(opciones: List<OpcionSerializada?>) {
        this.opciones = ArrayList<Opcion>()
        opciones.forEach(Consumer<OpcionSerializada> { opcionSerializada: OpcionSerializada ->
            this.opciones.add(
                Opcion(opcionSerializada.getClave(), opcionSerializada.getTexto())
            )
        })
    }

    fun construirPregunta(): Pregunta? {
        return Pregunta(textoPregunta, comportamiento, opciones)
    }