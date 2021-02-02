package model.builders

import model.Opcion
import model.Pregunta
import model.comportamientos.Comportamiento
import model.comportamientos.ComportamientoVoF
import model.comportamientos.ComportamientoVoFPenalidad
import model.data.OpcionSerializada
import model.excepciones.DiferenteTipoPreguntaException
import java.util.ArrayList
import java.util.function.Consumer

class VoFBuilder : Builder {
    var comportamiento: Comportamiento? = null
    private var textoPregunta: String? = null
    private var opciones: MutableList<Opcion>? = null

    fun asignarComportamiento(tipoPuntaje: String) {
        if (tipoPuntaje == "Clasico") {
            comportamiento = ComportamientoVoF()
        } else if (tipoPuntaje == "Penalidad") {
            comportamiento = ComportamientoVoFPenalidad()
        } else {
            throw DiferenteTipoPreguntaException()
        }
    }

    fun setEnunciado(enunciado: String?) {
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

    fun construirPregunta(): Pregunta {
        return Pregunta(textoPregunta, comportamiento, opciones)
    }
}