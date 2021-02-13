package test

import model.Jugador
import model.Opcion
import model.OpcionConjunto
import model.Pregunta
import model.comportamientos.ComportamientoMultipleChoiceClasico
import model.comportamientos.ComportamientoVoF
import model.modificadores.Exclusividad
import model.modificadores.SinExclusividad
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.ArrayList

class ExclusividadTest {
    @Test
    fun test01JugadorActivaExclusividadUnaVezYGana2PuntosEnVOFClasico() {
        val jugador1 = Jugador("Kevin")
        val jugador2 = Jugador("Mitnick")
        jugador1.jugadorSiguiente = jugador2
        jugador2.jugadorSiguiente = jugador1
        val preguntaVoF = Pregunta("Testing", ComportamientoVoF())
        val opcionesElegidasPorJugador1: ArrayList<Opcion> = ArrayList<Opcion>()
        val opcionesElegidasPorJugador2: ArrayList<Opcion> = ArrayList<Opcion>()
        var exclusividad: Exclusividad = SinExclusividad()
        exclusividad = preguntaVoF.activarExclusividad(exclusividad)!!
        opcionesElegidasPorJugador1.add(OpcionConjunto("1", "Es QA", "1"))
        opcionesElegidasPorJugador2.add(OpcionConjunto("2", "No es hacker", "1"))
        jugador1.elegirOpciones(opcionesElegidasPorJugador1)
        jugador1.jugadorSiguiente.elegirOpciones(opcionesElegidasPorJugador2)
        exclusividad.definirPuntosJugadoresEnPregunta(preguntaVoF, jugador1)
        Assertions.assertEquals(2, jugador1.puntos)
        Assertions.assertEquals(0, jugador2.puntos)
    }

    @Test
    fun test02JugadorActivaExclusividadUnaVezYAmbosRespondenConOpcionesCorrectasEnVoFClasicoYNoGananPuntos() {
        val jugador1 = Jugador("Kevin")
        val jugador2 = Jugador("Mitnick")
        jugador1.jugadorSiguiente = jugador2
        jugador2.jugadorSiguiente = jugador1
        val preguntaVoF = Pregunta("Testing", ComportamientoVoF())
        val opcionesElegidasPorJugador1: ArrayList<Opcion> = ArrayList<Opcion>()
        val opcionesElegidasPorJugador2: ArrayList<Opcion> = ArrayList<Opcion>()
        jugador1.elegirRespuestasAPreguntaActual(opcionesElegidasPorJugador1)
        jugador2.elegirRespuestasAPreguntaActual(opcionesElegidasPorJugador2)
        var exclusividad: Exclusividad = SinExclusividad()
        exclusividad = preguntaVoF.activarExclusividad(exclusividad)!!
        opcionesElegidasPorJugador1.add(OpcionConjunto("1", "Es QA", "1"))
        opcionesElegidasPorJugador2.add(OpcionConjunto("2", "No es hacker", "2"))
        exclusividad.definirPuntosJugadoresEnPregunta(preguntaVoF, jugador1)
        Assertions.assertEquals(0, jugador1.puntos)
        Assertions.assertEquals(0, jugador2.puntos)
    }

    @Test
    fun test03JugadorNoActivaExclusividadYAmbosRespondenConOpcionesCorrectasEnVoFClasicoRecibenPuntosComoSiNoTuvieranExclusividadActivado() {
        val jugador1 = Jugador("Kevin")
        val jugador2 = Jugador("Mitnick")
        jugador1.jugadorSiguiente = jugador2
        jugador2.jugadorSiguiente = jugador1
        val preguntaVoF = Pregunta("Testing", ComportamientoVoF())
        val opcionesElegidasPorJugador1: ArrayList<Opcion> = ArrayList<Opcion>()
        val opcionesElegidasPorJugador2: ArrayList<Opcion> = ArrayList<Opcion>()
        jugador1.elegirRespuestasAPreguntaActual(opcionesElegidasPorJugador1)
        jugador2.elegirRespuestasAPreguntaActual(opcionesElegidasPorJugador2)
        val exclusividad: Exclusividad = SinExclusividad()
        opcionesElegidasPorJugador1.add(OpcionConjunto("1", "Es QA", "1"))
        opcionesElegidasPorJugador2.add(OpcionConjunto("2", "No es hacker", "2"))
        exclusividad.definirPuntosJugadoresEnPregunta(preguntaVoF, jugador1)
        Assertions.assertEquals(1, jugador1.puntos)
        Assertions.assertEquals(1, jugador2.puntos)
    }

    @Test
    fun test04JugadorActivaExclusividadDosVecesYGana4PuntosEnPreguntaVoFClasico() {
        val jugador1 = Jugador("Kevin")
        val jugador2 = Jugador("Mitnick")
        jugador1.jugadorSiguiente = jugador2
        jugador2.jugadorSiguiente = jugador1
        val preguntaVoF = Pregunta("Testing", ComportamientoVoF())
        val opcionesElegidasPorJugador1: ArrayList<Opcion> = ArrayList<Opcion>()
        val opcionesElegidasPorJugador2: ArrayList<Opcion> = ArrayList<Opcion>()
        var exclusividad: Exclusividad = SinExclusividad()
        exclusividad = preguntaVoF.activarExclusividad(exclusividad)!!
        exclusividad = preguntaVoF.activarExclusividad(exclusividad)!!
        opcionesElegidasPorJugador1.add(OpcionConjunto("1", "Es QA", "1"))
        opcionesElegidasPorJugador2.add(OpcionConjunto("2", "No es hacker", "1"))
        jugador1.elegirRespuestasAPreguntaActual(opcionesElegidasPorJugador1)
        jugador2.elegirRespuestasAPreguntaActual(opcionesElegidasPorJugador2)
        exclusividad.definirPuntosJugadoresEnPregunta(preguntaVoF, jugador1)
        Assertions.assertEquals(4, jugador1.puntos)
        Assertions.assertEquals(0, jugador2.puntos)
    }

    @Test
    fun test05JugadorActivaExclusividadDosVecesYAmbosRespondenConOpcionesCorrectasEnPreguntaConVoFClasicoNoGananPuntos() {
        val jugador1 = Jugador("Kevin")
        val jugador2 = Jugador("Mitnick")
        jugador1.jugadorSiguiente = jugador2
        jugador2.jugadorSiguiente = jugador1
        val preguntaVoF = Pregunta("Testing", ComportamientoVoF())
        val opcionesElegidasPorJugador1: ArrayList<Opcion> = ArrayList<Opcion>()
        val opcionesElegidasPorJugador2: ArrayList<Opcion> = ArrayList<Opcion>()
        jugador1.elegirRespuestasAPreguntaActual(opcionesElegidasPorJugador1)
        jugador2.elegirRespuestasAPreguntaActual(opcionesElegidasPorJugador2)
        var exclusividad: Exclusividad = SinExclusividad()
        exclusividad = preguntaVoF.activarExclusividad(exclusividad)!!
        exclusividad = preguntaVoF.activarExclusividad(exclusividad)!!
        opcionesElegidasPorJugador1.add(OpcionConjunto("1", "Es QA", "1"))
        opcionesElegidasPorJugador2.add(OpcionConjunto("2", "No es hacker", "2"))
        exclusividad.definirPuntosJugadoresEnPregunta(preguntaVoF, jugador1)
        Assertions.assertEquals(0, jugador1.puntos)
        Assertions.assertEquals(0, jugador2.puntos)
    }

    @Test
    fun test06JugadorActivaExclusividadUnaVezEnMultipleChoiceClasicoRespondeConOpcionesCorrectasRecibeElDobleDePuntos() {
        val jugador1 = Jugador("Kevin")
        val jugador2 = Jugador("Mitnick")
        jugador1.jugadorSiguiente = jugador2
        jugador2.jugadorSiguiente = jugador1
        val preguntaVoF = Pregunta("Testing", ComportamientoMultipleChoiceClasico())
        val opcionesElegidasPorJugador1: ArrayList<Opcion> = ArrayList<Opcion>()
        val opcionesElegidasPorJugador2: ArrayList<Opcion> = ArrayList<Opcion>()
        jugador1.elegirRespuestasAPreguntaActual(opcionesElegidasPorJugador1)
        jugador2.elegirRespuestasAPreguntaActual(opcionesElegidasPorJugador2)
        var exclusividad: Exclusividad = SinExclusividad()
        exclusividad = preguntaVoF.activarExclusividad(exclusividad)!!
        opcionesElegidasPorJugador1.add(OpcionConjunto("1", "Es QA", "1"))
        opcionesElegidasPorJugador2.add(OpcionConjunto("2", "No es hacker", "1"))
        exclusividad.definirPuntosJugadoresEnPregunta(preguntaVoF, jugador1)
        Assertions.assertEquals(2, jugador1.puntos)
        Assertions.assertEquals(0, jugador2.puntos)
    }

    @Test
    fun test07JugadorActivaExclusividadUnaVezEnMultipleChoiceClasicoYAmbosRespondenConOpcionesCorrectasNoRecibenPuntos() {
        val jugador1 = Jugador("Kevin")
        val jugador2 = Jugador("Mitnick")
        jugador1.jugadorSiguiente = jugador2
        jugador2.jugadorSiguiente = jugador1
        val preguntaVoF = Pregunta("Testing", ComportamientoMultipleChoiceClasico())
        val opcionesElegidasPorJugador1: ArrayList<Opcion> = ArrayList<Opcion>()
        val opcionesElegidasPorJugador2: ArrayList<Opcion> = ArrayList<Opcion>()
        jugador1.elegirRespuestasAPreguntaActual(opcionesElegidasPorJugador1)
        jugador2.elegirRespuestasAPreguntaActual(opcionesElegidasPorJugador2)
        var exclusividad: Exclusividad = SinExclusividad()
        exclusividad = preguntaVoF.activarExclusividad(exclusividad)!!
        opcionesElegidasPorJugador1.add(OpcionConjunto("1", "Es QA", "1"))
        opcionesElegidasPorJugador2.add(OpcionConjunto("2", "Es hacker", "2"))
        exclusividad.definirPuntosJugadoresEnPregunta(preguntaVoF, jugador1)
        Assertions.assertEquals(0, jugador1.puntos)
        Assertions.assertEquals(0, jugador2.puntos)
    }

    @Test
    fun test08JugadorActivaExclusividadDosVecesEnMultipleChoiceClasicoRespondeConOpcionesCorrectasRecibe4VecesSusPuntos() {
        val jugador1 = Jugador("Kevin")
        val jugador2 = Jugador("Mitnick")
        jugador1.jugadorSiguiente = jugador2
        jugador2.jugadorSiguiente = jugador1
        val preguntaVoF = Pregunta("Testing", ComportamientoMultipleChoiceClasico())
        val opcionesElegidasPorJugador1: ArrayList<Opcion> = ArrayList<Opcion>()
        val opcionesElegidasPorJugador2: ArrayList<Opcion> = ArrayList<Opcion>()
        jugador1.elegirRespuestasAPreguntaActual(opcionesElegidasPorJugador1)
        jugador2.elegirRespuestasAPreguntaActual(opcionesElegidasPorJugador2)
        var exclusividad: Exclusividad = SinExclusividad()
        exclusividad = preguntaVoF.activarExclusividad(exclusividad)!!
        exclusividad = preguntaVoF.activarExclusividad(exclusividad)!!
        opcionesElegidasPorJugador1.add(OpcionConjunto("1", "Es QA", "1"))
        opcionesElegidasPorJugador2.add(OpcionConjunto("2", "No es hacker", "1"))
        exclusividad.definirPuntosJugadoresEnPregunta(preguntaVoF, jugador1)
        Assertions.assertEquals(4, jugador1.puntos)
        Assertions.assertEquals(0, jugador2.puntos)
    }
}
