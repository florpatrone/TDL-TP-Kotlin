package test

import model.Opcion
import model.OpcionConjunto
import model.Pregunta
import model.comportamientos.ComportamientoVoF
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.ArrayList

class ComportamientoVoFITest {
    @Test
    fun test01ObtenerPuntajeConUnaOpcionCorrectaEnComportamientoVoFDevuelve1Punto() {
        val pregunta = Pregunta("", ComportamientoVoF())
        val opcionesElegidasPorJugador: ArrayList<Opcion> = ArrayList<Opcion>()
        opcionesElegidasPorJugador.add(OpcionConjunto("1", "", "1"))
        Assertions.assertEquals(1, pregunta.obtenerPuntaje(opcionesElegidasPorJugador))
    }

    @Test
    fun test02ObtenerPuntajeConUnaOpcionIncorrectaEnComportamientoVoFNoDevuelvePuntos() {
        val pregunta = Pregunta("Texto de Pregunta", ComportamientoVoF())
        val opcionesElegidasPorJugador: ArrayList<Opcion> = ArrayList<Opcion>()
        opcionesElegidasPorJugador.add(OpcionConjunto("1", "", "2"))
        Assertions.assertEquals(0, pregunta.obtenerPuntaje(opcionesElegidasPorJugador))
    }

    @Test
    fun test02SeIngresanMasDeDosOpcionesEnComportamientoVoFYLanzaExcepcion() {
        val opcionesOriginales: ArrayList<Opcion> = ArrayList<Opcion>()
        opcionesOriginales.add(OpcionConjunto("1", "", "1"))
        opcionesOriginales.add(OpcionConjunto("2", "", "2"))
        opcionesOriginales.add(OpcionConjunto("3", "", "3"))
        Assertions.assertThrows(
            RuntimeException::class.java
        ) {
            val comportamiento = ComportamientoVoF(opcionesOriginales)
        }
    }

    @Test
    fun test03SeIngresanMenosDeDosOpcionesEnComportamientoVoFYLanzaExcepcion() {
        val opcionesOriginales: ArrayList<Opcion> = ArrayList<Opcion>()
        opcionesOriginales.add(OpcionConjunto("1", "", "1"))
        Assertions.assertThrows(
            RuntimeException::class.java
        ) {
            val comportamiento = ComportamientoVoF(opcionesOriginales)
        }
    }

    @Test
    fun test04SeIngresanDosOpcionesYNoLanzaExcepcion() {
        val opcionesOriginales: ArrayList<Opcion> = ArrayList<Opcion>()
        opcionesOriginales.add(OpcionConjunto("1", "", "1"))
        opcionesOriginales.add(OpcionConjunto("2", "", "2"))
        Assertions.assertDoesNotThrow {
            val comportamiento = ComportamientoVoF(opcionesOriginales)
        }
    }
}