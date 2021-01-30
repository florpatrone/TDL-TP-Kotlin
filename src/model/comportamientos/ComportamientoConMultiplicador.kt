package model.comportamientos

import model.Jugador
import model.modificadores.Multiplicador

interface ComportamientoConMultiplicador {
    fun agregarMultiplicadorAJugador(jugador: Jugador?, multiplicador: Multiplicador?)
}