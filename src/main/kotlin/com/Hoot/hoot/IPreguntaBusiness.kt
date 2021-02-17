package com.Hoot.hoot

import model.Pregunta
import model.data.FormatoPregunta

interface IPreguntaBusiness {

    fun list(): List<FormatoPregunta>
    fun load(idPregunta:Long): FormatoPregunta
    fun save(pregunta:FormatoPregunta): FormatoPregunta
    fun remove(idPregunta:Long)
}