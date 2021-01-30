package model.comportamientos

import model.Opcion
import model.Puntaje
import model.PuntajeClasico
import model.excepciones.CantidadDeOpcionesInvalidasException
import model.modificadores.Exclusividad

class ComportamientoVoF : Comportamiento, ComportamientoConExclusividad {
    constructor() {}
    constructor(opciones: List<Opcion?>) {
        if (opciones.size != 2) throw CantidadDeOpcionesInvalidasException()
    }

    override fun crearPuntaje(): Puntaje {
        return PuntajeClasico()
    }

    override val tipoPregunta: String
        get() = "Verdadero o Falso"

    override fun activarExclusividad(exclusividad: Exclusividad?): Exclusividad? {
        return exclusividad!!.activarExclusividad()
    }
}
