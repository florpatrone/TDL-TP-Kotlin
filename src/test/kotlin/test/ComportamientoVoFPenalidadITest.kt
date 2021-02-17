package test

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.ArrayList

internal class ComportamientoVoFPenalidadITest {
    @Test
    fun test01ObtenerPuntajeConUnaOpcionCorrectaEnComportamientoVoFPenalidadDevuelveUnPunto() {
        val pregunta = Pregunta("", ComportamientoVoFPenalidad())
        val opcionesElegidasPorJugador: ArrayList<Opcion> = ArrayList<Opcion>()
        opcionesElegidasPorJugador.add(OpcionConjunto("Incorrecta", "", "1"))
        Assertions.assertEquals(-1, pregunta.obtenerPuntaje(opcionesElegidasPorJugador))
    }

    @Test
    fun test02ObtenerPuntajeConUnaOpcionIncorrectaEnComportamientoVoFPenalidadDevuelveMenosUnPunto() {
        val pregunta = Pregunta("", ComportamientoVoFPenalidad())
        val opcionesElegidasPorJugador: ArrayList<Opcion> = ArrayList<Opcion>()
        opcionesElegidasPorJugador.add(OpcionConjunto("2", "", "1"))
        Assertions.assertEquals(-1, pregunta.obtenerPuntaje(opcionesElegidasPorJugador))
    }

    @Test
    fun test03SeIngresanMasDeDosOpcionesEnComportamientoVoFPenalidadLanzaExcepcion() {
        val opcionesOriginales: ArrayList<Opcion> = ArrayList<Opcion>()
        opcionesOriginales.add(Opcion("1", ""))
        opcionesOriginales.add(Opcion("2", ""))
        opcionesOriginales.add(Opcion("3", ""))
        Assertions.assertThrows(
            RuntimeException::class.java
        ) {
            val comportamiento = ComportamientoVoFPenalidad(opcionesOriginales)
        }
    }

    @Test
    fun test04SeIngresanMenosDeDosOpcionesEnComportamientoVoFPenalidadLanzaExcepcion() {
        val opcionesOriginales: ArrayList<Opcion> = ArrayList<Opcion>()
        opcionesOriginales.add(Opcion("1", ""))
        Assertions.assertThrows(
            RuntimeException::class.java
        ) {
            val comportamiento = ComportamientoVoFPenalidad(opcionesOriginales)
        }
    }

    @Test
    fun test05SeIngresanDosOpcionesEnComportamientoVoFPenalidadNoLanzaExcepcion() {
        val opcionesOriginales: ArrayList<Opcion> = ArrayList<Opcion>()
        opcionesOriginales.add(Opcion("1", ""))
        opcionesOriginales.add(Opcion("2", ""))
        Assertions.assertDoesNotThrow {
            val comportamiento = ComportamientoVoFPenalidad(opcionesOriginales)
        }
    }
}