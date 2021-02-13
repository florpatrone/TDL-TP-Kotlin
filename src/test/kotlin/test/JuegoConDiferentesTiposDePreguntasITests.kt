package test

import model.Jugador
import model.Opcion
import model.OpcionConjunto
import model.Pregunta
import model.comportamientos.ComportamientoMultipleChoiceClasico
import model.comportamientos.ComportamientoMultipleChoiceParcial
import model.comportamientos.ComportamientoVoF
import model.comportamientos.ComportamientoVoFPenalidad
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.ArrayList

class JuegoConDiferentesTiposDePreguntasITests {
    @Test
    fun test01JugadorContestaCon3RespuestasCorrectasDeMultipleChoiceParcialYVoFPenalidadConUnaIncorrectaTienePuntaje2() {
        val jugador = Jugador("marcos")
        val preguntaMultipleChoice = Pregunta("cuales son personajes anime??", ComportamientoMultipleChoiceParcial())
        val respuestasDeJugador: ArrayList<Opcion> = ArrayList<Opcion>()
        respuestasDeJugador.add(OpcionConjunto("Correcta", "naruto", "Correcta"))
        respuestasDeJugador.add(OpcionConjunto("Correcta", "saske", "Correcta"))
        respuestasDeJugador.add(OpcionConjunto("Correcta", "jiraiya", "Correcta"))
        jugador.procesarPregunta(preguntaMultipleChoice, respuestasDeJugador)
        respuestasDeJugador.clear()
        val preguntaVoFPenalidad = Pregunta("", ComportamientoVoFPenalidad())
        respuestasDeJugador.add(OpcionConjunto("Incorrecta", "", "Correcta"))
        jugador.procesarPregunta(preguntaVoFPenalidad, respuestasDeJugador)
        Assertions.assertEquals(2, jugador.puntos)
    }

    @Test
    fun test02JugadorContestaCon2CorrectasDeChoiceClasicoYUnaIncorrectaDeVoFTienePuntaje1() {
        val jugador = Jugador("")
        val preguntaMultipleChoiceClasico = Pregunta("", ComportamientoMultipleChoiceClasico())
        val respuestasJugador: ArrayList<Opcion> = ArrayList<Opcion>()
        respuestasJugador.add(OpcionConjunto("Correcta", "", "Correcta"))
        respuestasJugador.add(OpcionConjunto("Correcta", "", "Correcta"))
        jugador.procesarPregunta(preguntaMultipleChoiceClasico, respuestasJugador)
        respuestasJugador.clear()
        val preguntaVoF = Pregunta("", ComportamientoVoF())
        respuestasJugador.add(OpcionConjunto("Correcta", "", "Incorrecta"))
        jugador.procesarPregunta(preguntaVoF, respuestasJugador)
        Assertions.assertEquals(1, jugador.puntos)
    }
}