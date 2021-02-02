package test

import model.Pregunta
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class PreguntaTest {
    @Test
    fun deberiaCrearsePreguntaConElTextoCorrespondiente() {
        val pregunta = Pregunta("El texto de una pregunta", null)
        Assertions.assertEquals("El texto de una pregunta", pregunta.enunciado)
    }
}