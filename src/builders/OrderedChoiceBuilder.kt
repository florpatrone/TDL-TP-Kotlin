package builders

import java.util.ArrayList
import java.util.function.Consumer

class OrderedChoiceBuilder : Builder {
    var comportamiento: Comportamiento? = null
    private var textoPregunta: String? = null
    private var opciones: MutableList<Opcion>? = null
    fun asignarComportamiento(tipoPuntaje: String) {
        if (tipoPuntaje != "Clasico") throw DiferenteTipoPreguntaException()
        comportamiento = ComportamientoOrderedChoice()
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
