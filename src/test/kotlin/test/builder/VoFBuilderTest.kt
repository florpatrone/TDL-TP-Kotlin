package test.builder

import model.builders.VoFBuilder
import model.data.OpcionSerializada
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.ArrayList

internal class VoFBuilderTest {
    @Test
    fun VoFBuilderInstanciaUnaPreguntaCorrectamente() {
        val opciones: List<OpcionSerializada> = ArrayList<OpcionSerializada>()
        val voFBuilder = VoFBuilder()
        voFBuilder.setOpciones(opciones)
        voFBuilder.asignarComportamiento("Clasico")
        voFBuilder.textoPregunta = "ejemplo"
        val vof: Pregunta = voFBuilder.construirPregunta()!!
        //TODO: Agregar test unitario que verifique los atributos de
        // pregunta como el enunciado y las opciones son correctas - 3/2 asserts
        Assertions.assertTrue(true)
    }
}