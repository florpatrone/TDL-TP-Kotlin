package test

import model.Opcion
import model.OpcionConjunto
import model.Pregunta
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.ArrayList
import model.comportamientos.ComportamientoMultipleChoicePenalidad


class ComportamientoMultipleChoicePenalidadTest {
    @Test
    fun test01SeCreaElComportamientoCon5OpcionesYNoLanzaException() {
        val opcionesOriginales: ArrayList<Opcion> = ArrayList<Opcion>()
        opcionesOriginales.add(OpcionConjunto("1", "", "1"))
        opcionesOriginales.add(OpcionConjunto("2", "", "2"))
        opcionesOriginales.add(OpcionConjunto("3", "", "3"))
        opcionesOriginales.add(OpcionConjunto("4", "", "4"))
        opcionesOriginales.add(OpcionConjunto("5", "", "5"))
        Assertions.assertDoesNotThrow {
            val comportamiento =
                ComportamientoMultipleChoicePenalidad(opcionesOriginales)
        }
    }

    @Test
    fun test02SeCreaElComportamientoCon1OpcionYLanzaException() {
        val opcionesOriginales: ArrayList<Opcion> = ArrayList<Opcion>()
        opcionesOriginales.add(Opcion("1", ""))
        Assertions.assertThrows(
            RuntimeException::class.java
        ) {
            val comportamiento =
                ComportamientoMultipleChoicePenalidad(opcionesOriginales)
        }
    }

    @Test
    fun test03SeCreaElComportamientoCon6OpcionesYLanzaException() {
        val opcionesOriginales: ArrayList<Opcion> = ArrayList<Opcion>()
        opcionesOriginales.add(OpcionConjunto("1", "", "1"))
        opcionesOriginales.add(OpcionConjunto("2", "", "2"))
        opcionesOriginales.add(OpcionConjunto("3", "", "3"))
        opcionesOriginales.add(OpcionConjunto("4", "", "4"))
        opcionesOriginales.add(OpcionConjunto("5", "", "5"))
        opcionesOriginales.add(OpcionConjunto("6", "", "6"))
        Assertions.assertThrows(
            RuntimeException::class.java
        ) {
            val comportamiento =
                ComportamientoMultipleChoicePenalidad(opcionesOriginales)
        }
    }

    @Test
    fun test04ObtenerPuntajeCon3OpcionesCorrectasEnMultipleChoicePenalidadDevuelve3Puntos() {
        val pregunta = Pregunta("Pregunta", ComportamientoMultipleChoicePenalidad())
        //Jugador jugador = new Jugador("Pepe");
        val opcionesElegidasPorJugador: ArrayList<Opcion> = ArrayList<Opcion>()
        opcionesElegidasPorJugador.add(OpcionConjunto("1", "Opcion 1", "1"))
        opcionesElegidasPorJugador.add(OpcionConjunto("1", "Opcion 2", "1"))
        opcionesElegidasPorJugador.add(OpcionConjunto("1", "Opcion 3", "1"))
        Assertions.assertEquals(3, pregunta.obtenerPuntaje(opcionesElegidasPorJugador))
    }

    @Test
    fun test05ObtenerPuntajeCon3OpcionesCorrectasYUnaIncorrectaEnMultipleChoicePenalidadDevuelve2Puntos() {
        val pregunta = Pregunta("Pregunta", ComportamientoMultipleChoicePenalidad())
        val opcionesElegidasPorJugador: ArrayList<Opcion> = ArrayList<Opcion>()
        opcionesElegidasPorJugador.add(OpcionConjunto("1", "Opcion Correcta", "1"))
        opcionesElegidasPorJugador.add(OpcionConjunto("2", "Opcion Correcta", "2"))
        opcionesElegidasPorJugador.add(OpcionConjunto("3", "Opcion Correcta", "3"))
        opcionesElegidasPorJugador.add(OpcionConjunto("4", "Opcion Incorrecta", "3"))
        Assertions.assertEquals(2, pregunta.obtenerPuntaje(opcionesElegidasPorJugador))
    }

    @Test
    fun test05ObtenerPuntajeCon4OpcionesIncorrectasEnMultipleChoicePenalidadDevuelveMenos4Puntos() {
        val pregunta = Pregunta("Pregunta", ComportamientoMultipleChoicePenalidad())
        val opcionesElegidasPorJugador: ArrayList<Opcion> = ArrayList<Opcion>()
        opcionesElegidasPorJugador.add(OpcionConjunto("1", "", "2"))
        opcionesElegidasPorJugador.add(OpcionConjunto("2", "", "1"))
        opcionesElegidasPorJugador.add(OpcionConjunto("3", "", "4"))
        opcionesElegidasPorJugador.add(OpcionConjunto("4", "", "3"))
        Assertions.assertEquals(-4, pregunta.obtenerPuntaje(opcionesElegidasPorJugador))
    }
}