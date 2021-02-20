import com.Hoot.hoot.model.Juego
import com.hooting.hooting.data.Pregunta
import com.hooting.hooting.data.Respuesta
import com.hooting.hooting.web.PreguntaRestController
import org.junit.jupiter.api.Test
import org.springframework.web.servlet.function.EntityResponse

class JuegoTest {

    var preguntaRestController: PreguntaRestController = PreguntaRestController()

    @Test
    fun test01PullData() {
        var juego: Juego = Juego()
        //juego.empezarJuego("Juan","Marcos")

        //var preguntas: ArrayList<Pregunta> = juego.preguntas
        //print(preguntas)
        //preguntas.forEach{pregunta -> println(pregunta.enunciado) }

        var EntityResponse = preguntaRestController.load(1)
        var pregunta: Pregunta? = EntityResponse.body

        println(pregunta)
        var respuestas: ArrayList<Respuesta> = pregunta!!.respuestas
        respuestas.forEach{ respuesta -> }

        //preguntaRestController.load(0))

        var respuestas2: List<Pregunta>? = preguntaRestController.list().body
        print(respuestas2)

    }

}