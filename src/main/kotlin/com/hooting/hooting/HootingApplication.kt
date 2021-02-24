package com.hooting.hooting

import com.Hoot.hoot.model.Juego
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

		val respuesta = Respuesta("Fahrenheit 451",true)
		val respuesta2 = Respuesta("Cronicas Marcianas",true)
		val respuesta3 = Respuesta("Bovedas de Acero",false)
		val respuesta4 = Respuesta("Remedio para melancolicos",true)
		val respuesta5 = Respuesta("El fin de la infancia",false)
		val respuesta6 = Respuesta("Pink Floyd", false)
		val respuesta7 = Respuesta("Queen", false)
		val respuesta8 = Respuesta("Metallica", true)
		val respuesta9 = Respuesta("Black Sabbath", false)
		val respuesta10 = Respuesta("DragonForce", false)
		val respuesta11 = Respuesta("Kotlin", true)
		val respuesta12 = Respuesta("Brainfuck", true)
		val respuesta13 = Respuesta("HTML", false)
		val respuesta14 = Respuesta("Oz", true)
		val respuesta15 = Respuesta("CSS", false)
		val respuesta16 = Respuesta("Falso",false)
		val respuesta17 = Respuesta("Verdadero",true)


		val respuestas: ArrayList<Respuesta> = ArrayList<Respuesta>()
		val respuestas2: ArrayList<Respuesta> = ArrayList<Respuesta>()
		val respuestas3: ArrayList<Respuesta> = ArrayList<Respuesta>()
		val respuestas4: ArrayList<Respuesta> = ArrayList<Respuesta>()


		respuestas.add(respuesta)
		respuestas.add(respuesta2)
		respuestas.add(respuesta3)
		respuestas.add(respuesta4)
		respuestas.add(respuesta5)

		respuestas2.add(respuesta6)
		respuestas2.add(respuesta7)
		respuestas2.add(respuesta8)
		respuestas2.add(respuesta9)
		respuestas2.add(respuesta10)

		respuestas3.add(respuesta11)
		respuestas3.add(respuesta12)
		respuestas3.add(respuesta13)
		respuestas3.add(respuesta14)
		respuestas3.add(respuesta15)

		respuestas4.add(respuesta16)
		respuestas4.add(respuesta17)

		val pregunta = Pregunta("choice", "Cuales de las siguientes son obras de Ray Bradbury?",0, respuestas,3)
		val pregunta2 = Pregunta("choice", "Cuales de las siguientes bandas no son inglesas?",1, respuestas2,1)
		val pregunta3 = Pregunta("choice", "Cuales de los siguientes son lenguajes de programacion?",2, respuestas3,2)
		val pregunta4 = Pregunta("vof", "12 * 12 = 144?",3, respuestas3,1)


		preguntaService!!.savePreguntaDetails(pregunta)
		preguntaService!!.savePreguntaDetails(pregunta2)
		preguntaService!!.savePreguntaDetails(pregunta3)
		preguntaService!!.savePreguntaDetails(pregunta4)

	}
}

	fun main(args: Array<String>) {
		runApplication<HootingApplication>(*args)

	}
