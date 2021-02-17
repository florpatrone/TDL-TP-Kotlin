package com.Hoot.hoot

import model.Pregunta
import model.data.FormatoPregunta
import model.data.Respuesta

interface IRespuestaBusiness {

    fun list(): List<Respuesta>
    fun load(idRespuesta:Long): Respuesta
    fun save(respuesta:Respuesta): Respuesta
    fun remove(id:Long)
}