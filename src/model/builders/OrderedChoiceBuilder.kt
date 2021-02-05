package model.builders

import model.Opcion
import model.OpcionConjunto
import model.Pregunta
import model.comportamientos.Comportamiento
import model.comportamientos.ComportamientoOrderedChoice
import model.data.OpcionSerializada
import model.excepciones.DiferenteTipoPreguntaException
import java.util.ArrayList
import java.util.function.Consumer

class OrderedChoiceBuilder : Builder {
    var comportamiento: Comportamiento? = null
    private var textoPregunta: String? = null
    private var opciones: List<OpcionSerializada?>?  = null

    override fun asignarComportamiento(tipoPuntaje: String?) {
        if (tipoPuntaje != "Clasico") throw DiferenteTipoPreguntaException()
        comportamiento = ComportamientoOrderedChoice()
    }

    override fun construirPregunta(): Pregunta? {
        return Pregunta(textoPregunta, comportamiento!!, opciones)
    }

    override fun setEnunciado(enunciado: String) {
        textoPregunta = enunciado
    }

    override fun setOpciones(opciones: List<OpcionSerializada?>?) {
        this.opciones = ArrayList<Opcion?>()
        opciones!!.forEach(Consumer { opcionSerializada: OpcionSerializada ->
            this.opciones.add(
                OpcionConjunto(opcionSerializada.getClave(), opcionSerializada.getTexto())
            )
        })
    }
}