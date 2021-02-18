package com.hooting.hooting

import com.hooting.hooting.dao.PreguntaRepository
import com.hooting.hooting.data.Pregunta
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HootingApplication :  CommandLineRunner {

	@Autowired
	val preguntaRepository: PreguntaRepository? = null

	override fun run(vararg args: String?) {

		val pregunta = Pregunta("vof", "hola como estas?")
		preguntaRepository!!.save(pregunta)
		//var preg_control = PreguntaRestController()
		//preg_control.insert(pregunta)
	}
}

	fun main(args: Array<String>) {
		runApplication<HootingApplication>(*args)

	}
