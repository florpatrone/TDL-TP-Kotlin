package com.hooting.hooting

import com.hooting.hooting.business.PreguntaService
import com.hooting.hooting.data.Pregunta
import com.hooting.hooting.data.Respuesta
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HootingApplication :  CommandLineRunner {

	@Autowired
	val preguntaService: PreguntaService? = null


	override fun run(vararg args: String?) {

		val respuesta = Respuesta("Verdadero",true)
		val respuesta2 = Respuesta("Falso",false)
		val respuesta3 = Respuesta("Verdadero",true)
		val respuesta4 = Respuesta("Falso",false)
		val respuesta5 = Respuesta("Verdadero",true)
		val respuesta6 = Respuesta("Falso",false)

		val respuestas: ArrayList<Respuesta> = ArrayList<Respuesta>()
		val respuestas2: ArrayList<Respuesta> = ArrayList<Respuesta>()
		val respuestas3: ArrayList<Respuesta> = ArrayList<Respuesta>()

		respuestas.add(respuesta)
		respuestas.add(respuesta2)

		respuestas2.add(respuesta3)
		respuestas2.add(respuesta4)

		respuestas3.add(respuesta5)
		respuestas3.add(respuesta6)

		val pregunta = Pregunta("vof", "hola como estas?",0, respuestas)
		val pregunta2 = Pregunta("vof", "El cielo es azul?",1, respuestas2)
		val pregunta3 = Pregunta("vof", "Boca es el mas grande?",2, respuestas3)

		preguntaService!!.savePreguntaDetails(pregunta)
		preguntaService!!.savePreguntaDetails(pregunta2)
		preguntaService!!.savePreguntaDetails(pregunta3)

	}
}

	fun main(args: Array<String>) {
		runApplication<HootingApplication>(*args)

	}
