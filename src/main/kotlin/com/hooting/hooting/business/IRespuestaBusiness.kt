package com.hooting.hooting.business

import com.hooting.hooting.data.Respuesta


interface IRespuestaBusiness {

    fun list(): List<Respuesta>
    fun load(idRespuesta:Long): Respuesta
    fun save(respuesta:Respuesta): Respuesta
    fun remove(id:Long)
}