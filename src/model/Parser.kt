package model

import com.google.gson.Gson
import model.builders.*
import model.comportamientos.ComportamientoVoF
import model.data.PreguntaSerializada
import java.io.BufferedReader
import java.io.FileNotFoundException
import java.io.FileReader
import java.io.IOException
import java.util.*
import java.util.function.Consumer


class Parser {
    private fun convertirPreguntas(preguntaSerializadas: List<PreguntaSerializada>?): Pregunta {
        val preguntas = ArrayList<Pregunta>()
        preguntaSerializadas?.forEach(Consumer<PreguntaSerializada> { preguntaSerializada: PreguntaSerializada ->
            val tipoPregunta: String? = preguntaSerializada.getType()
            val director = DirectorPregunta(preguntaSerializada)
            when (tipoPregunta) {
                "vof" -> {
                    val voFBuilder = VoFBuilder()
                    director.asignar(voFBuilder)
                    preguntas.add(voFBuilder.construirPregunta())
                }
                "multiple" -> {
                    val multipleChoiceBuilder = MultipleChoiceBuilder()
                    director.asignar(multipleChoiceBuilder)
                    preguntas.add(multipleChoiceBuilder.construirPregunta())
                }
                "order" -> {
                    val orderedChoiceBuilder = OrderedChoiceBuilder()
                    director.asignar(orderedChoiceBuilder)
                    preguntas.add(orderedChoiceBuilder.construirPregunta())
                }
                else -> {
                    val groupChoiceBuilder = GroupChoiceBuilder()
                    director.asignar(groupChoiceBuilder)
                    preguntas.add(groupChoiceBuilder.construirPregunta())
                }
            }
        })
        preguntas.add(Pregunta("", ComportamientoVoF()))
        return convertirEnPreguntaCiclica(preguntas)
    }

    private fun convertirEnPreguntaCiclica(preguntas: ArrayList<Pregunta>): Pregunta {
        val actual = preguntas[0] //[p1]+ p*
        var siguiente: Pregunta
        if (preguntas.size > 1) {
            siguiente = preguntas[1]
            actual.siguientePregunta = siguiente
            for (i in 2 until preguntas.size) { //4 ("")
                siguiente.siguientePregunta = preguntas[i]
                siguiente = preguntas[i]
            }
        }
        return actual
    }

    fun parsear(): Pregunta {
        val gson = Gson()
        var br: BufferedReader? = null
        var preguntaSerializadas: List<PreguntaSerializada>
        try {
            br = BufferedReader(FileReader("data.json"))
            preguntaSerializadas = Arrays.asList(gson.fromJson(br, Array<PreguntaSerializada>::class.java))
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } finally {
            if (br != null) {
                try {
                    br.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }
        assert(preguntaSerializadas != null)
        return convertirPreguntas(preguntaSerializadas)
    }
}