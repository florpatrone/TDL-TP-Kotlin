package com.Hoot.hoot

import dao.PreguntaRepository
import model.Pregunta
import model.data.FormatoPregunta
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HootApplication:CommandLineRunner{

	@Autowired
	val preguntaRepository: PreguntaRepository? = null

	override fun run(vararg args: String?) {

		val pregunta = FormatoPregunta("vof", "hola como estas?")
		preguntaRepository!!.save(pregunta)
	}
}

fun main(args: Array<String>) {
	runApplication<HootApplication>(*args)
}
