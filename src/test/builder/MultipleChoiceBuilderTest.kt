package test.builder

import model.Pregunta
import model.builders.MultipleChoiceBuilder
import model.data.OpcionSerializada
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.ArrayList

internal class MultipleChoiceBuilderTest {
    @Test
    fun MultipleChoiceBuilderInstanciaUnaPreguntaCorrectamente() {
        val opciones: List<OpcionSerializada> = ArrayList<OpcionSerializada>()
        val multipleChoiceBuilder = MultipleChoiceBuilder()
        multipleChoiceBuilder.setOpciones(opciones)
        multipleChoiceBuilder.asignarComportamiento("Clasico")
        multipleChoiceBuilder.setEnunciado("ejemplo")
        val mc: Pregunta = multipleChoiceBuilder.construirPregunta()!!
        //TODO: Agregar test unitario que verifique los atributos de
        // pregunta como el enunciado y las opciones son correctas - 3/2 asserts
        Assertions.assertTrue(true)
    }
}