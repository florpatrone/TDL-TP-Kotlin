package test.builder

import model.Pregunta
import model.builders.OrderedChoiceBuilder
import model.data.OpcionSerializada
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.ArrayList

internal class OrderedChoiceBuilderTest {
    @Test
    fun OrderChoiceBuilderInstanciaUnaPreguntaCorrectamente() {
        val opciones: List<OpcionSerializada> = ArrayList<OpcionSerializada>()
        val orderedChoiceBuilder = OrderedChoiceBuilder()
        orderedChoiceBuilder.setOpciones(opciones)
        orderedChoiceBuilder.asignarComportamiento("Clasico")
        orderedChoiceBuilder.setEnunciado("ejemplo")
        val orden: Pregunta = orderedChoiceBuilder.construirPregunta()!!
        //TODO: Agregar test unitario que verifique los atributos de
        // pregunta como el enunciado y las opciones son correctas - 3/2 asserts
        Assertions.assertTrue(true)
    }
}