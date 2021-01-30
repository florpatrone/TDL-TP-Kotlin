package test

import model.Jugador
import model.Opcion
import model.OpcionConjunto
import model.Pregunta
import model.comportamientos.ComportamientoMultipleChoiceParcial
import model.modificadores.Exclusividad
import model.modificadores.SinExclusividad
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.ArrayList

class MultipleChoiceParcialITest {
    @Test
    fun test01JugadorContestaCon3RespuestasCorrectasDevuelve3Puntos() {
        val pregunta = Pregunta("Pregunta", ComportamientoMultipleChoiceParcial())
        val respuestas: ArrayList<Opcion> = ArrayList<Opcion>()
        respuestas.add(OpcionConjunto("1", "", "1")) // Correcta
        respuestas.add(OpcionConjunto("2", "", "2")) // Correcta
        respuestas.add(OpcionConjunto("3", "", "3")) // Correcta
        Assertions.assertEquals(3, pregunta.obtenerPuntaje(respuestas))
    }

    @Test
    fun test02JugadorContestaCon2RespuestasCorrectasYUnaIncorrectaAlFinalTienePuntos0() {
        val pregunta = Pregunta("Pregunta", ComportamientoMultipleChoiceParcial())
        val respuestas: ArrayList<Opcion> = ArrayList<Opcion>()
        respuestas.add(OpcionConjunto("1", "", "1")) // Correcta
        respuestas.add(OpcionConjunto("2", "", "2")) // Correcta
        respuestas.add(OpcionConjunto("3", "", "1")) // Incorrecta
        Assertions.assertEquals(0, pregunta.obtenerPuntaje(respuestas))
    }

    @Test
    fun test03JugadorContestaPrimeroConRespuestaIncorrectaYLuegoCon2RespuestasCorrectasYDevuelve0Puntos() {
        val pregunta = Pregunta("Pregunta", ComportamientoMultipleChoiceParcial())
        val respuestas: ArrayList<Opcion> = ArrayList<Opcion>()
        respuestas.add(OpcionConjunto("1", "", "2")) // Incorrecta
        respuestas.add(OpcionConjunto("2", "", "2")) // Correcta
        respuestas.add(OpcionConjunto("3", "", "3")) // Correcta
        Assertions.assertEquals(0, pregunta.obtenerPuntaje(respuestas))
    }

    @Test
    fun test04JuegoEntreDosJugadoresCon3Preguntas() {
        val pregunta = Pregunta("Pregunta", ComportamientoMultipleChoiceParcial())
        val jugador1 = Jugador("Jugador 1")
        val jugador2 = Jugador("Jugador 2")
        jugador1.setJugadorSiguiente(jugador2)
        jugador2.setJugadorSiguiente(jugador1)
        val exclusividad: Exclusividad = SinExclusividad()
        val respuestasDeJugador1: ArrayList<Opcion> = ArrayList<Opcion>()
        val respuestasDeJugador2: ArrayList<Opcion> = ArrayList<Opcion>()

        //	Multiple Choice con 2 respuestas y una respuesta incorrecta
        respuestasDeJugador1.add(OpcionConjunto("Correcta", "", "Correcta"))
        respuestasDeJugador1.add(OpcionConjunto("Correcta", "", "Correcta"))
        respuestasDeJugador2.add(OpcionConjunto("Correcta", "", "Correcta"))
        respuestasDeJugador2.add(OpcionConjunto("Correcta", "", "Incorrecta"))
        jugador1.elegirRespuestasAPreguntaActual(respuestasDeJugador1)
        jugador2.elegirRespuestasAPreguntaActual(respuestasDeJugador2)
        exclusividad.definirPuntosJugadoresEnPregunta(pregunta, jugador1)
        Assertions.assertEquals(2, jugador1.getPuntos())
        Assertions.assertEquals(0, jugador2.getPuntos())
        respuestasDeJugador1.clear()
        respuestasDeJugador2.clear()

        // Jugador 1 responde una correcta y Jugador 2 responde 3 correctas
        respuestasDeJugador1.add(OpcionConjunto("Correcta", "", "Correcta"))
        respuestasDeJugador2.add(OpcionConjunto("Correcta", "", "Correcta"))
        respuestasDeJugador2.add(OpcionConjunto("Correcta", "", "Correcta"))
        respuestasDeJugador2.add(OpcionConjunto("Correcta", "", "Correcta"))
        jugador1.elegirRespuestasAPreguntaActual(respuestasDeJugador1)
        jugador2.elegirRespuestasAPreguntaActual(respuestasDeJugador2)
        exclusividad.definirPuntosJugadoresEnPregunta(pregunta, jugador1)
        Assertions.assertEquals(3, jugador1.getPuntos())
        Assertions.assertEquals(3, jugador2.getPuntos())
        respuestasDeJugador1.clear()
        respuestasDeJugador2.clear()
        respuestasDeJugador1.add(OpcionConjunto("Correcta", "", "Correcta"))
        respuestasDeJugador1.add(OpcionConjunto("Correcta", "", "Incorrecta"))
        respuestasDeJugador2.add(OpcionConjunto("Correcta", "", "Correcta"))
        respuestasDeJugador2.add(OpcionConjunto("Correcta", "", "Correcta"))
        respuestasDeJugador2.add(OpcionConjunto("Correcta", "", "Correcta"))
        jugador1.elegirRespuestasAPreguntaActual(respuestasDeJugador1)
        jugador2.elegirRespuestasAPreguntaActual(respuestasDeJugador2)
        exclusividad.definirPuntosJugadoresEnPregunta(pregunta, jugador1)
        Assertions.assertEquals(3, jugador1.getPuntos())
        Assertions.assertEquals(6, jugador2.getPuntos())
    }

    @Test
    fun test05SeIngresanMasDe5OpcionesEnComportamientoMultipleChoiceParcialYLanzaExcepcion() {
        val opcionesOriginales: ArrayList<Opcion> = ArrayList<Opcion>()
        opcionesOriginales.add(Opcion("1", ""))
        opcionesOriginales.add(Opcion("2", ""))
        opcionesOriginales.add(Opcion("3", ""))
        opcionesOriginales.add(Opcion("4", ""))
        opcionesOriginales.add(Opcion("5", ""))
        opcionesOriginales.add(Opcion("6", ""))
        Assertions.assertThrows(
            RuntimeException::class.java
        ) {
            val comportamiento =
                ComportamientoMultipleChoiceParcial(opcionesOriginales)
        }
    }

    @Test
    fun test06SeIngresanMenosDe2OpcionesEnComportamientoMultipleChoiceParcialYLanzaExcepcion() {
        val opcionesOriginales: ArrayList<Opcion> = ArrayList<Opcion>()
        opcionesOriginales.add(Opcion("1", ""))
        Assertions.assertThrows(
            RuntimeException::class.java
        ) {
            val comportamiento =
                ComportamientoMultipleChoiceParcial(opcionesOriginales)
        }
    }

    @Test
    fun test07SeOpciones2OpcionesEnComportamientoMultipleChoiceParcialYNoLanzaExcepcion() {
        val opcionesOriginales: ArrayList<Opcion> = ArrayList<Opcion>()
        opcionesOriginales.add(Opcion("1", ""))
        opcionesOriginales.add(Opcion("2", ""))
        Assertions.assertDoesNotThrow {
            val comportamiento =
                ComportamientoMultipleChoiceParcial(opcionesOriginales)
        }
    }
}