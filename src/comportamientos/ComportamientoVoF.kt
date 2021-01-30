package comportamientos

import model.comportamientos.Comportamiento
import model.Opcion
import model.Puntaje
import model.PuntajeClasico
import model.excepciones.CantidadDeOpcionesInvalidasException

class ComportamientoVoF : Comportamiento {
    constructor() {}
    constructor(opciones: List<Opcion?>) {
        if (opciones.size != 2) throw CantidadDeOpcionesInvalidasException()
    }

    override fun crearPuntaje(): Puntaje {
        return PuntajeClasico()
    }

    override val tipoPregunta: String
        get() = "Verdadero o Falso"

}
