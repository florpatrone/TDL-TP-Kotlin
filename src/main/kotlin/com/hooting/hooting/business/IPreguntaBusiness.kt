package com.hooting.hooting.business

import com.hooting.hooting.data.Pregunta

interface IPreguntaBusiness {

    fun list(): List<Pregunta>
    fun load(idPregunta:Long): Pregunta
    fun save(pregunta: Pregunta): Pregunta
    fun remove(idPregunta:Long)
}