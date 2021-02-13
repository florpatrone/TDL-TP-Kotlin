package model.comportamientos

import model.Opcion
import model.excepciones.CantidadDeOpcionesInvalidasException
import model.Puntaje
import model.PuntajeParcial
import model.modificadores.Exclusividad

class ComportamientoMultipleChoiceParcial : Comportamiento, ComportamientoConExclusividad {
    constructor() {}
    constructor(opciones: List<Opcion?>) {
        if (opciones.size < 2 || opciones.size > 5) throw CantidadDeOpcionesInvalidasException()
    }

    override fun crearPuntaje(): Puntaje {
        return PuntajeParcial()
    }

    override val tipoPregunta: String
        get() = "Multiple Choice Parcial"

    override fun activarExclusividad(exclusividad: Exclusividad): Exclusividad {
        return exclusividad.activarExclusividad()
    }
}