import com.Hoot.hoot.model.Juego
import com.hooting.hooting.data.Pregunta
import com.hooting.hooting.web.PreguntaRestController
import org.junit.jupiter.api.Test

class JuegoTest {

    var preguntaRestController: PreguntaRestController = PreguntaRestController()

    @Test
    fun test01PullData() {
        var juego: Juego = Juego()
        //juego.empezarJuego("Juan","Marcos")

        //var preguntas: ArrayList<Pregunta> = juego.preguntas
        //print(preguntas)
        //preguntas.forEach{pregunta -> println(pregunta.enunciado) }

        print(preguntaRestController.load(1))
        //preguntaRestController.load(0))

    }

}