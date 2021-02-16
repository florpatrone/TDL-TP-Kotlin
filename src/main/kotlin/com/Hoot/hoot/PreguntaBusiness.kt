package com.Hoot.hoot

import dao.PreguntaRepository
import model.Pregunta
import model.excepciones.BusinessException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PreguntaBusiness: IPreguntaBusiness {

    @Autowired
    val PreguntaRepository : PreguntaRepository? = null

    override fun list(): List<Pregunta> {
        try{
            return PreguntaRepository!!.findAll()
        }catch (e: Exception){
            throw BusinessException(e.message)
        }
    }

    override fun load(idPregunta: Long): Pregunta {
        TODO("Not yet implemented")
    }

    override fun save(persona: Pregunta): Pregunta {
        TODO("Not yet implemented")
    }

    override fun remove(idPregunta: Long) {
        TODO("Not yet implemented")
    }
}