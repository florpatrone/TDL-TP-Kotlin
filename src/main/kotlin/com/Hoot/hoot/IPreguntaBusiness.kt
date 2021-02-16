package com.Hoot.hoot

import model.Pregunta

interface IPreguntaBusiness {

    fun list(): List<Pregunta>
    fun load(idPregunta:Long): Pregunta
    fun save(persona:Pregunta): Pregunta
    fun remove(idPregunta:Long)
}