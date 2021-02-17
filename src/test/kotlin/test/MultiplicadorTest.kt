package test

import model.modificadores.Multiplicador
import model.modificadores.MultiplicadorX2
import model.modificadores.MultiplicadorX3
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.ArrayList

class MultiplicadorTest {
    @Test
    fun test01ActivarMultiplicadorX2ConOpcionIncorrectaEnVoFPenalidadDevuelveMenos2EnObtenerPuntaje() {
        val preguntaVoF = Pregunta("La Pregunta", ComportamientoVoFPenalidad())
        val opciones: ArrayList<Opcion> = ArrayList<Opcion>()
        val multiplicador: Multiplicador = MultiplicadorX2()
        opciones.add(OpcionConjunto("Incorrecta", "", "1"))
        Assertions.assertEquals(-2, preguntaVoF.obtenerPuntaje(opciones, multiplicador))
    }

    @Test
    fun test02ActivarMultiplicadorX3ConOpcionCorrectaEnVoFClasicoDevuelve3EnObtenerPuntaje() {
        val preguntaVoF = Pregunta("La Pregunta", ComportamientoVoFPenalidad())
        val opciones: ArrayList<Opcion> = ArrayList<Opcion>()
        val multiplicador: Multiplicador = MultiplicadorX3()
        opciones.add(OpcionConjunto("1", "", "1"))
        Assertions.assertEquals(3, preguntaVoF.obtenerPuntaje(opciones, multiplicador))
    }

    @Test
    fun test03ActivarMultiplicadorX2ConVariasOpcionesCorrectasEnMultipleChoiceParcialDevuelveElDobleDePuntosEnObtenerPuntaje() {
        val preguntaMultipleChoicePenalidad = Pregunta("La Pregunta", ComportamientoMultipleChoicePenalidad())
        val opciones: ArrayList<Opcion> = ArrayList<Opcion>()
        val multiplicador: Multiplicador = MultiplicadorX2()
        opciones.add(OpcionConjunto("1", "", "1"))
        opciones.add(OpcionConjunto("2", "", "2"))
        Assertions.assertEquals(4, preguntaMultipleChoicePenalidad.obtenerPuntaje(opciones, multiplicador))
    }

    @Test
    fun test03ActivarMultiplicadorX3ConVariasOpcionesCorrectasEnMultipleChoicePenalidadDevuelveElTripleDePuntosEnObtenerPuntaje() {
        val preguntaVoF = Pregunta("La Pregunta", ComportamientoMultipleChoicePenalidad())
        val opciones: ArrayList<Opcion> = ArrayList<Opcion>()
        val multiplicador: Multiplicador = MultiplicadorX3()
        opciones.add(OpcionConjunto("1", "", "1"))
        opciones.add(OpcionConjunto("2", "", "2"))
        Assertions.assertEquals(6, preguntaVoF.obtenerPuntaje(opciones, multiplicador))
    }

    @Test
    fun test04ActivarMultiplicadorX2ConOpcionIncorrectaEnVoFPenalidadDevuelveMenosElDobleDePuntosEnObtenerPuntaje() {
        val preguntaVoF = Pregunta("La Pregunta", ComportamientoVoFPenalidad())
        val opciones: ArrayList<Opcion> = ArrayList<Opcion>()
        val multiplicador: Multiplicador = MultiplicadorX2()
        opciones.add(OpcionConjunto("Incorrecta", "", "1"))
        Assertions.assertEquals(-2, preguntaVoF.obtenerPuntaje(opciones, multiplicador))
    }

    @Test
    fun test05ActivarMultiplicadorX3ConOpcionIncorrectaEnVoFPenalidadDevuelveMenosElTripleDePuntosEnObtenerPuntaje() {
        val preguntaVoF = Pregunta("La Pregunta", ComportamientoVoFPenalidad())
        val opciones: ArrayList<Opcion> = ArrayList<Opcion>()
        val multiplicador: Multiplicador = MultiplicadorX3()
        opciones.add(OpcionConjunto("Incorrecta", "", "1"))
        Assertions.assertEquals(-3, preguntaVoF.obtenerPuntaje(opciones, multiplicador))
    }
}