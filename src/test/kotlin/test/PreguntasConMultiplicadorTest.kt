package test

import model.Jugador
import model.Opcion
import model.OpcionConjunto
import model.Pregunta
import model.comportamientos.ComportamientoMultipleChoicePenalidad
import model.comportamientos.ComportamientoVoFPenalidad
import model.modificadores.*
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.ArrayList

class PreguntasConMultiplicadorTest {
    @Test
    fun test01JugadorActivaMultiplicadorX2EnVoFPenalidadRespondeConOpcionCorrectaGana2Puntos() {
        val jugador1 = Jugador("Cthulhu")
        val jugador2 = Jugador("Nyarlathotep")
        jugador1.jugadorSiguiente =jugador2
        jugador2.jugadorSiguiente =jugador1
        val preguntaVoF = Pregunta("La pregunta", ComportamientoVoFPenalidad())
        val opcionesJugador1: ArrayList<Opcion> = ArrayList<Opcion>()
        val opcionesJugador2: ArrayList<Opcion> = ArrayList<Opcion>()
        val multiplicador: Multiplicador = MultiplicadorX2()
        preguntaVoF.agregarMultiplicadorAJugador(jugador1, multiplicador)
        val exclusividad: Exclusividad = SinExclusividad()
        opcionesJugador1.add(OpcionConjunto("1", "El pulpo loco", "1"))
        opcionesJugador2.add(OpcionConjunto("2", "Es buena onda", "1"))
        jugador1.elegirRespuestasAPreguntaActual(opcionesJugador1)
        jugador2.elegirRespuestasAPreguntaActual(opcionesJugador2)
        exclusividad.definirPuntosJugadoresEnPregunta(preguntaVoF, jugador1)
        Assertions.assertEquals(2, jugador1.puntos)
        Assertions.assertEquals(-1, jugador2.puntos)
    }

    @Test
    fun test02JugadorActivaMultiplicadorX3EnVoFPenalidadRespondeConOpcionCorrectaGana2Puntos() {
        val jugador1 = Jugador("Cthulhu")
        val jugador2 = Jugador("Nyarlathotep")
        jugador1.jugadorSiguiente = jugador2
        jugador2.jugadorSiguiente = jugador1
        val preguntaVoF = Pregunta("La pregunta", ComportamientoVoFPenalidad())
        val opcionesJugador1: ArrayList<Opcion> = ArrayList<Opcion>()
        val opcionesJugador2: ArrayList<Opcion> = ArrayList<Opcion>()
        val multiplicador: Multiplicador = MultiplicadorX3()
        preguntaVoF.agregarMultiplicadorAJugador(jugador1, multiplicador)
        val exclusividad: Exclusividad = SinExclusividad()
        opcionesJugador1.add(OpcionConjunto("1", "El pulpo loco", "1"))
        opcionesJugador2.add(OpcionConjunto("2", "Es buena onda", "1"))
        jugador1.elegirRespuestasAPreguntaActual(opcionesJugador1)
        jugador2.elegirRespuestasAPreguntaActual(opcionesJugador2)
        exclusividad.definirPuntosJugadoresEnPregunta(preguntaVoF, jugador1)
        Assertions.assertEquals(3, jugador1.puntos)
        Assertions.assertEquals(-1, jugador2.puntos)
    }

    @Test
    fun test03SeAgreganMultiplicadorX2EnAmbosJugadoresEnVoFPenalidadRespondenConOpcionCorrectaGanan2Puntos() {
        val jugador1 = Jugador("Cthulhu")
        val jugador2 = Jugador("Nyarlathotep")
        jugador1.jugadorSiguiente = jugador2
        jugador2.jugadorSiguiente = jugador1
        val preguntaVoF = Pregunta("La pregunta", ComportamientoVoFPenalidad())
        val opcionesJugador1: ArrayList<Opcion> = ArrayList<Opcion>()
        val opcionesJugador2: ArrayList<Opcion> = ArrayList<Opcion>()
        val multiplicador: Multiplicador = MultiplicadorX2()
        preguntaVoF.agregarMultiplicadorAJugador(jugador1, multiplicador)
        preguntaVoF.agregarMultiplicadorAJugador(jugador2, multiplicador)
        val exclusividad: Exclusividad = SinExclusividad()
        opcionesJugador1.add(OpcionConjunto("1", "El pulpo loco", "1"))
        opcionesJugador2.add(OpcionConjunto("2", "No es buena onda", "2"))
        jugador1.elegirRespuestasAPreguntaActual(opcionesJugador1)
        jugador2.elegirRespuestasAPreguntaActual(opcionesJugador2)
        exclusividad.definirPuntosJugadoresEnPregunta(preguntaVoF, jugador1)
        Assertions.assertEquals(2, jugador1.puntos)
        Assertions.assertEquals(2, jugador2.puntos)
    }

    @Test
    fun test04SeAgreganMultiplicadorDistintosEnAmbosJugadoresEnVoFPenalidadRespondenConOpcionCorrectaGanan2PuntosY3PuntosRespectivamente() {
        val jugador1 = Jugador("Cthulhu")
        val jugador2 = Jugador("Nyarlathotep")
        jugador1.jugadorSiguiente = jugador2
        jugador2.jugadorSiguiente = jugador1
        val preguntaVoF = Pregunta("La pregunta", ComportamientoVoFPenalidad())
        val opcionesJugador1: ArrayList<Opcion> = ArrayList<Opcion>()
        val opcionesJugador2: ArrayList<Opcion> = ArrayList<Opcion>()
        jugador1.elegirRespuestasAPreguntaActual(opcionesJugador1)
        jugador2.elegirRespuestasAPreguntaActual(opcionesJugador2)
        preguntaVoF.agregarMultiplicadorAJugador(jugador1, MultiplicadorX2())
        preguntaVoF.agregarMultiplicadorAJugador(jugador2, MultiplicadorX3())
        val exclusividad: Exclusividad = SinExclusividad()
        opcionesJugador1.add(OpcionConjunto("1", "El pulpo loco", "1"))
        opcionesJugador2.add(OpcionConjunto("2", "No es buena onda", "2"))
        exclusividad.definirPuntosJugadoresEnPregunta(preguntaVoF, jugador1)
        Assertions.assertEquals(2, jugador1.puntos)
        Assertions.assertEquals(3, jugador2.puntos)
    }

    @Test
    fun test05UnJugadorUsaMultiplicadorx2EnMultipleChoicePenalidadRespondenConOpcionesIncorrectasTieneMenos2Puntos() {
        val jugador1 = Jugador("Cthulhu")
        val jugador2 = Jugador("Nyarlathotep")
        jugador1.jugadorSiguiente = jugador2
        jugador2.jugadorSiguiente = jugador1
        val preguntaVoF = Pregunta("La pregunta", ComportamientoMultipleChoicePenalidad())
        val opcionesJugador1: ArrayList<Opcion> = ArrayList<Opcion>()
        val opcionesJugador2: ArrayList<Opcion> = ArrayList<Opcion>()
        jugador1.elegirRespuestasAPreguntaActual(opcionesJugador1)
        jugador2.elegirRespuestasAPreguntaActual(opcionesJugador2)
        preguntaVoF.agregarMultiplicadorAJugador(jugador1, MultiplicadorX2())
        val exclusividad: Exclusividad = SinExclusividad()
        opcionesJugador1.add(OpcionConjunto("1", "El pulpo loco", "2"))
        opcionesJugador2.add(OpcionConjunto("2", "No es buena onda", "1"))
        exclusividad.definirPuntosJugadoresEnPregunta(preguntaVoF, jugador1)
        Assertions.assertEquals(-2, jugador1.puntos)
        Assertions.assertEquals(-1, jugador2.puntos)
    }

    @Test
    fun test06UnJugadorUsaMultiplicadorx3EnMultipleChoicePenalidadRespondenConOpcionesIncorrectasTieneMenos3Puntos() {
        val jugador1 = Jugador("Cthulhu")
        val jugador2 = Jugador("Nyarlathotep")
        jugador1.jugadorSiguiente = jugador2
        jugador2.jugadorSiguiente = jugador1
        val preguntaVoF = Pregunta("La pregunta", ComportamientoMultipleChoicePenalidad())
        val opcionesJugador1: ArrayList<Opcion> = ArrayList<Opcion>()
        val opcionesJugador2: ArrayList<Opcion> = ArrayList<Opcion>()
        jugador1.elegirRespuestasAPreguntaActual(opcionesJugador1)
        jugador2.elegirRespuestasAPreguntaActual(opcionesJugador2)
        preguntaVoF.agregarMultiplicadorAJugador(jugador1, MultiplicadorX3())
        val exclusividad: Exclusividad = SinExclusividad()
        opcionesJugador1.add(OpcionConjunto("1", "El pulpo loco", "2"))
        opcionesJugador2.add(OpcionConjunto("2", "No es buena onda", "1"))
        exclusividad.definirPuntosJugadoresEnPregunta(preguntaVoF, jugador1)
        Assertions.assertEquals(-3, jugador1.puntos)
        Assertions.assertEquals(-1, jugador2.puntos)
    }
}