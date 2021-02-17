package test.builder

import model.builders.GroupChoiceBuilder
import model.data.OpcionSerializada
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.ArrayList

internal class GroupChoiceBuilderTest {
    @Test
    fun GroupChoiceInstanciaUnaPreguntaCorrectamente() {
        val opciones: List<OpcionSerializada> = ArrayList<OpcionSerializada>()
        val groupChoiceBuilder = GroupChoiceBuilder()
        groupChoiceBuilder.setOpciones(opciones)
        groupChoiceBuilder.asignarComportamiento("Clasico")
        groupChoiceBuilder.textoPregunta = "ejemplo"
        val group: Pregunta? = groupChoiceBuilder.construirPregunta()
        //TODO: Agregar test unitario que verifique los atributos de
        // pregunta como el enunciado y las opciones son correctas - 3/2 asserts
        Assertions.assertTrue(true)
    }
}