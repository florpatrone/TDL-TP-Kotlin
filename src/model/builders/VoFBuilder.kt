package model.builders

import model.Opcion
import model.OpcionConjunto
import model.Pregunta
import model.comportamientos.Comportamiento
import model.comportamientos.ComportamientoVoF
import model.comportamientos.ComportamientoVoFPenalidad
import model.data.OpcionSerializada
import model.excepciones.DiferenteTipoPreguntaException
import java.util.ArrayList
import java.util.function.Consumer

class VoFBuilder : Builder {
    lateinit var comportamiento: Comportamiento
    private lateinit var textoPregunta: String
    private var opciones: ArrayList<OpcionConjunto>

    constructor() {
        opciones = ArrayList<OpcionConjunto>()
    }

    override fun asignarComportamiento(tipoPuntaje: String?) {
        comportamiento = if (tipoPuntaje == "Clasico") {
            ComportamientoVoF()
        } else if (tipoPuntaje == "Penalidad") {
            ComportamientoVoFPenalidad()
        } else {
            throw DiferenteTipoPreguntaException()
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