package com.Hoot.hoot

import model.data.Pregunta

interface IPreguntaBusiness {

    fun list(): List<Pregunta>
    fun load(idPregunta:Long): Pregunta
    fun save(pregunta:Pregunta): Pregunta
    fun remove(idPregunta:Long)
}