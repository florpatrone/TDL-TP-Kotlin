package comportamientos

import model.Jugador
import model.Opcion
import model.Puntaje
import model.PuntajePenalidad
import model.modificadores.Multiplicador
import model.excepciones.CantidadDeOpcionesInvalidasException

class ComportamientoVoFPenalidad : Comportamiento, ComportamientoConMultiplicador {
    constructor() {}
    constructor(opciones: List<Opcion?>) {
        if (opciones.size != 2) throw CantidadDeOpcionesInvalidasException()
    }

    override fun crearPuntaje(): Puntaje {
        return PuntajePenalidad()
    }

    override val tipoPregunta: String
        get() = "Verdadero o Falso Penalidad"

    override fun agregarMultiplicadorAJugador(jugador: Jugador?, multiplicador: Multiplicador?) {
        jugador!!.setMultiplicador(multiplicador)
    }
}