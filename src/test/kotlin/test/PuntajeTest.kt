package test

import model.Puntaje
import model.PuntajeClasico
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class PuntajeTest {
    @Test
    fun test01PuntajeClasicoDevuelveCeroCuandoSeAnula() {
        val puntaje = PuntajeClasico()
        puntaje.accionCorrecta()
        puntaje.accionCorrecta()
        puntaje.accionIncorrecta()
        Assertions.assertEquals(0, puntaje.puntajeAcumulado)
    }

    @Test
    fun test02PuntajeClasicoSeIncrementaVariasVecesDevuelve1() {
        val puntaje = PuntajeClasico()
        puntaje.accionCorrecta()
        puntaje.accionCorrecta()
        puntaje.accionCorrecta()
        Assertions.assertEquals(1, puntaje.puntajeAcumulado)
    }

    @Test
    fun test03PuntajeParcialSeIncrementa3VecesDevuelvePuntaje3() {
        val puntaje = PuntajeParcial()
        puntaje.accionCorrecta()
        puntaje.accionCorrecta()
        puntaje.accionCorrecta()
        Assertions.assertEquals(3, puntaje.puntajeAcumulado)
    }

    @Test
    fun test04PuntajeParcialSeIncrementa2VecesYSeAnulaUnaVezDevuelvePuntaje0() {
        val puntaje = PuntajeParcial()
        puntaje.accionCorrecta()
        puntaje.accionCorrecta()
        puntaje.accionIncorrecta()
        Assertions.assertEquals(0, puntaje.puntajeAcumulado)
    }

    @Test
    fun test05PuntajePenalidadSeIncrementa1VezDevuelvePuntaje1() {
        val puntaje: Puntaje = PuntajePenalidad()
        puntaje.accionCorrecta()
        Assertions.assertEquals(1, puntaje.puntajeAcumulado)
    }

    @Test
    fun test06PuntajePenalidadSeAnulaDevuelvePuntajeMenos1() {
        val puntaje: Puntaje = PuntajePenalidad()
        puntaje.accionIncorrecta()
        Assertions.assertEquals(-1, puntaje.puntajeAcumulado)
    }
}