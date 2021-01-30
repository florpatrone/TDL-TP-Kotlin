package comportamientos

import model.Jugador
import model.Opcion
import model.Puntaje
import model.PuntajePenalidad
import model.excepciones.CantidadDeOpcionesInvalidasException
import model.modificadores.Multiplicador

class ComportamientoMultipleChoicePenalidad : Comportamiento, ComportamientoConMultiplicador {
    constructor() {}
    constructor(opciones: List<Opcion?>) {
        if (opciones.size < 2 || opciones.size > 5) throw CantidadDeOpcionesInvalidasException()
    }

    override fun crearPuntaje(): Puntaje {
        return PuntajePenalidad()
    }

    override val tipoPregunta: String
        get() = "Multiple Choice Penalidad"

    override fun agregarMultiplicadorAJugador(jugador: Jugador?, multiplicador: Multiplicador?) {
        jugador!!.setMultiplicador(multiplicador)
    }
}