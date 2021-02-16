package model

import model.comportamientos.Comportamiento
import model.comportamientos.ComportamientoConExclusividad
import model.comportamientos.ComportamientoConMultiplicador
import model.modificadores.Exclusividad
import model.modificadores.Multiplicador
import java.util.ArrayList


/*@Entity
@Table(name = "pregunta")
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
var id:Long = 0*/
class Pregunta {
    lateinit var enunciado: String
    private var opciones: List<Opcion>? = null
    lateinit var comportamiento: Comportamiento
    lateinit var siguientePregunta: Pregunta

    constructor(enunciado: String, comportamiento: Comportamiento){
        this.comportamiento = comportamiento
        this.enunciado = enunciado
    }

    constructor(enunciado: String, comportamiento: Comportamiento, opciones: ArrayList<OpcionConjunto>){
        Pregunta(enunciado, comportamiento)
        this.opciones = opciones
    }

    val tipoPregunta: String
        get() = comportamiento.tipoPregunta

    fun obtenerPuntaje(opcionesElegidasPorElJugador: List<Opcion>): Int {
        return comportamiento.obtenerPuntaje(opcionesElegidasPorElJugador)
    }

    fun obtenerPuntaje(opcionesDeJugador: List<Opcion?>?, multiplicador: Multiplicador): Int {
        return multiplicador.modificarPuntos(comportamiento.obtenerPuntaje(opcionesDeJugador as List<Opcion>))
    }

    fun agregarMultiplicadorAJugador(jugador: Jugador, multiplicador: Multiplicador) {
        (comportamiento as ComportamientoConMultiplicador).agregarMultiplicadorAJugador(jugador, multiplicador)
    }

    fun activarExclusividad(exclusividad: Exclusividad): Exclusividad {
        return (comportamiento as ComportamientoConExclusividad).activarExclusividad(exclusividad)
    }
}
