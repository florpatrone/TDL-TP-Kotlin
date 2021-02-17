package test

import model.comportamientos.ComportamientoMultipleChoiceClasico
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.ArrayList

class MultipleChoiceClasicoITest {
    @Test
    fun test01JugadorContestaTodoCorrectamenteYDevuelve1Punto() {
        val pregunta = Pregunta("Pregunta", ComportamientoMultipleChoiceClasico())
        val respuestas: ArrayList<Opcion> = ArrayList<Opcion>()
        respuestas.add(OpcionConjunto("1", "", "1")) // Correcta
        respuestas.add(OpcionConjunto("2", "", "2")) // Correcta
        respuestas.add(OpcionConjunto("3", "", "3")) // Correcta
        Assertions.assertEquals(1, pregunta.obtenerPuntaje(respuestas))
    }

    @Test
    fun test02JugadorContesta2CorrectamenteY1IncorrectamenteYDevuelve0Puntos() {
        val pregunta = Pregunta("Pregunta", ComportamientoMultipleChoiceClasico())
        val respuestas: ArrayList<Opcion> = ArrayList<Opcion>()
        respuestas.add(OpcionConjunto("1", "", "1")) // Correcta
        respuestas.add(OpcionConjunto("2", "", "1")) // Incorrecta
        respuestas.add(OpcionConjunto("3", "", "3")) // Correcta
        Assertions.assertEquals(0, pregunta.obtenerPuntaje(respuestas))
    }

    @Test
    fun test03JugadorContesta4CorrectamenteY1IncorrectamenteYDevuelve0Puntos() {
        val pregunta = Pregunta("Pregunta", ComportamientoMultipleChoiceClasico())
        val respuestas: ArrayList<Opcion> = ArrayList<Opcion>()
        respuestas.add(OpcionConjunto("1", "", "1")) // Correcta
        respuestas.add(OpcionConjunto("2", "", "1")) // Incorrecta
        respuestas.add(OpcionConjunto("3", "", "3")) // Correcta
        respuestas.add(OpcionConjunto("4", "", "4")) // Correcta
        respuestas.add(OpcionConjunto("5", "", "5")) // Correcta
        Assertions.assertEquals(0, pregunta.obtenerPuntaje(respuestas))
    }

    @Test
    fun test04JugadorContestaTodoIncorrectamenteYDevuelve0Puntos() {
        val pregunta = Pregunta("Pregunta", ComportamientoMultipleChoiceClasico())
        val respuestas: ArrayList<Opcion> = ArrayList<Opcion>()
        respuestas.add(OpcionConjunto("1", "", "2")) // Incorrecta
        respuestas.add(OpcionConjunto("2", "", "1")) // Incorrecta
        respuestas.add(OpcionConjunto("3", "", "1")) // Incorrecta
        respuestas.add(OpcionConjunto("4", "", "1")) // Incorrecta
        respuestas.add(OpcionConjunto("5", "", "1")) // Incorrecta
        Assertions.assertEquals(0, pregunta.obtenerPuntaje(respuestas))
    }

    @Test
    fun test05JugadorContesta2CorrectamenteY1IncorrectamenteEnPrimerLugarYDevuelve0Puntos() {
        val pregunta = Pregunta("Pregunta", ComportamientoMultipleChoiceClasico())
        val respuestas: ArrayList<Opcion> = ArrayList<Opcion>()
        respuestas.add(OpcionConjunto("1", "", "2")) // Incorrecta
        respuestas.add(OpcionConjunto("2", "", "2")) // Correcta
        respuestas.add(OpcionConjunto("3", "", "3")) // Correcta
        Assertions.assertEquals(0, pregunta.obtenerPuntaje(respuestas))
    }

    @Test
    fun test06SeIngresanMasDe5OpcionesEnComportamientoMultipleChoiceClasicoYLanzaExcepcion() {
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
                ComportamientoMultipleChoiceClasico(opcionesOriginales)
        }
    }

    @Test
    fun test07SeIngresanMenosDe2OpcionesEnComportamientoMultipleChoiceClasicoYLanzaExcepcion() {
        val opcionesOriginales: ArrayList<Opcion> = ArrayList<Opcion>()
        opcionesOriginales.add(Opcion("1", ""))
        Assertions.assertThrows(
            RuntimeException::class.java
        ) {
            val comportamiento =
                ComportamientoMultipleChoiceClasico(opcionesOriginales)
        }
    }

    @Test
    fun test08SeIngresan2OpcionesEnComportamientoMultipleChoiceClasicoYNoLanzaExcepcion() {
        val opcionesOriginales: ArrayList<Opcion> = ArrayList<Opcion>()
        opcionesOriginales.add(Opcion("1", ""))
        opcionesOriginales.add(Opcion("2", ""))
        Assertions.assertDoesNotThrow {
            val comportamiento =
                ComportamientoMultipleChoiceClasico(opcionesOriginales)
        }
    }
}