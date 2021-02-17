package test

import model.Jugador
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.ArrayList

class PreguntaConRespuestasOrdenadasITest {
    @Test
    fun test01JugadorRespondeCon3RespuestasQueEstanOrdenadasGana1Punto() {
        val jugador = Jugador("")
        val pregunta = Pregunta("", ComportamientoOrderedChoice())
        val respuestasJugador: ArrayList<Opcion> = ArrayList<Opcion>()
        respuestasJugador.add(OpcionConjunto(Opcion("1", ""), "1"))
        respuestasJugador.add(OpcionConjunto(Opcion("2", ""), "2"))
        respuestasJugador.add(OpcionConjunto(Opcion("3", ""), "3"))
        jugador.procesarPregunta(pregunta, respuestasJugador)
        Assertions.assertEquals(1, jugador.puntos)
    }

    @Test
    fun test02JugadorRespondeCon3RespuestasDesordenadasNoGanaPuntos() {
        val jugador = Jugador("")
        val pregunta = Pregunta("", ComportamientoOrderedChoice())
        val respuestasJugador: ArrayList<Opcion> = ArrayList<Opcion>()
        respuestasJugador.add(OpcionConjunto(Opcion("1", ""), "1"))
        respuestasJugador.add(OpcionConjunto(Opcion("2", ""), "3"))
        respuestasJugador.add(OpcionConjunto(Opcion("3", ""), "2"))
        jugador.procesarPregunta(pregunta, respuestasJugador)
        Assertions.assertEquals(0, jugador.puntos)
    }
}