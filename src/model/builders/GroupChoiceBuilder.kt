package model.builders

import model.Opcion
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
    private var opciones: MutableList<Opcion>? = null

    override fun asignarComportamiento(tipoPuntaje: String?) {
        if (tipoPuntaje != "Clasico") throw DiferenteTipoPreguntaException()
        comportamiento = ComportamientoGroupChoice()
    }

    override fun setEnunciado(enunciado: String?) {
        textoPregunta = enunciado
    }

    fun setOpciones(opciones: List<OpcionSerializada?>) {
        this.opciones = ArrayList<Opcion>()
        opciones.forEach(Consumer<OpcionSerializada> { opcionSerializada: OpcionSerializada ->
            this.opciones!!.add(
                OpcionConjunto(opcionSerializada.getClave(), opcionSerializada.getTexto())
            )
        })
    }

    override fun construirPregunta(): Pregunta {
        return Pregunta(textoPregunta, comportamiento, opciones)
    }
}
