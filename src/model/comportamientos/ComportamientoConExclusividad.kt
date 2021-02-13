package model.comportamientos

import model.modificadores.Exclusividad

interface ComportamientoConExclusividad {
    fun activarExclusividad(exclusividad: Exclusividad): Exclusividad
}