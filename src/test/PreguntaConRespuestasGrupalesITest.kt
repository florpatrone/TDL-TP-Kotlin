package test

import model.Jugador
import model.Opcion
import model.OpcionConjunto
import model.Pregunta
import model.comportamientos.ComportamientoGroupChoice
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.ArrayList

class PreguntaConRespuestasGrupalesITest {
    @Test
    fun test01JugadorUsaDosOpcionesConClaveIgualANumeroGrupoGana1Punto() {
        val jugador = Jugador("")
        val pregunta = Pregunta("", ComportamientoGroupChoice())
        val respuestasJugador: ArrayList<Opcion> = ArrayList<Opcion>()
        respuestasJugador.add(OpcionConjunto(Opcion("1", "chihuahua"), "1"))
        respuestasJugador.add(OpcionConjunto(Opcion("1", "chihuahua"), "1"))
        jugador.procesarPregunta(pregunta, respuestasJugador)
        Assertions.assertEquals(1, jugador.getPuntos())
    }

    @Test
    fun test02JugadorUsaDosOpcionesConClavesDistintasANumeroGrupoNoGanaPunto() {
        val jugador = Jugador("")
        val pregunta = Pregunta("", ComportamientoGroupChoice())
        val respuestasJugador: ArrayList<Opcion> = ArrayList<Opcion>()
        respuestasJugador.add(OpcionConjunto(Opcion("1", "chihuahua"), "1"))
        respuestasJugador.add(OpcionConjunto(Opcion("1", "chihuahua"), "2"))
        jugador.procesarPregunta(pregunta, respuestasJugador)
        Assertions.assertEquals(0, jugador.getPuntos())
    }

    @Test
    fun test03JugadorUsaDosOpcionesEnUnGrupoYOtrosDosEnOtroGrupoConSusClavesIgualesANumeroGrupoGana1Punto() {
        val jugador = Jugador("")
        val pregunta = Pregunta("", ComportamientoGroupChoice())
        val respuestasJugador: ArrayList<Opcion> = ArrayList<Opcion>()
        respuestasJugador.add(OpcionConjunto(Opcion("1", "chihuahua"), "1"))
        respuestasJugador.add(OpcionConjunto(Opcion("1", "chihuahua"), "1"))
        respuestasJugador.add(OpcionConjunto(Opcion("2", "chihuahua"), "2"))
        respuestasJugador.add(OpcionConjunto(Opcion("2", "chihuahua"), "2"))
        jugador.procesarPregunta(pregunta, respuestasJugador)
        Assertions.assertEquals(1, jugador.getPuntos())
    }

    @Test
    fun test04JugadorUsaOpcionesEnGruposQueNoCorrespondenNoGanaPuntos() {
        val jugador = Jugador("")
        val pregunta = Pregunta("", ComportamientoGroupChoice())
        val respuestasJugador: ArrayList<Opcion> = ArrayList<Opcion>()
        respuestasJugador.add(OpcionConjunto(Opcion("1", "chihuahua"), "1"))
        respuestasJugador.add(OpcionConjunto(Opcion("1", "chihuahua"), "1"))
        respuestasJugador.add(OpcionConjunto(Opcion("1", "chihuahua"), "2"))
        respuestasJugador.add(OpcionConjunto(Opcion("2", "chihuahua"), "2"))
        jugador.procesarPregunta(pregunta, respuestasJugador)
        Assertions.assertEquals(0, jugador.getPuntos())
    }
}