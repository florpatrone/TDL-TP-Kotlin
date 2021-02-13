package test

import model.Pregunta
import model.comportamientos.ComportamientoVoF
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class PreguntaTest {
    @Test
    fun deberiaCrearsePreguntaConElTextoCorrespondiente() {
        val pregunta = Pregunta("El texto de una pregunta", ComportamientoVoF())
        Assertions.assertEquals("El texto de una pregunta", pregunta.enunciado)
    }
}