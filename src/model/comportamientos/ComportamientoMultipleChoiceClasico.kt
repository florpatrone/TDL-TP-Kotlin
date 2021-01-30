package model.comportamientos

import model.*
import model.excepciones.CantidadDeOpcionesInvalidasException

class ComportamientoMultipleChoiceClasico : Comportamiento {
    constructor() {}
    constructor(opciones: List<Opcion?>) {
        if (opciones.size < 2 || opciones.size > 5) throw CantidadDeOpcionesInvalidasException()
    }

    override fun crearPuntaje(): Puntaje {
        return PuntajeClasico()
    }

    override val tipoPregunta: String
        get() = "Multiple Choice Clasico"
}
