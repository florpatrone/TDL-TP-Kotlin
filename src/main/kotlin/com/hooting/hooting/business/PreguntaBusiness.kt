package com.hooting.hooting.business

import com.hooting.hooting.dao.PreguntaRepository
import com.hooting.hooting.excepciones.BusinessException
import com.hooting.hooting.data.Pregunta
import com.hooting.hooting.excepciones.NotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import kotlin.jvm.Throws

@Service
class PreguntaBusiness: IPreguntaBusiness {

    @Autowired
    val preguntaRepository : PreguntaRepository? = null

    @Throws(BusinessException::class)
    override fun list(): List<Pregunta> {
        try{
            return preguntaRepository!!.findAll()
        }catch (e: Exception){
            throw BusinessException(e.message)
        }
    }

    @Throws(BusinessException::class, NotFoundException::class)
    override fun load(idPregunta: Long): Pregunta {
        val op: Optional<Pregunta>
        try{
            op = preguntaRepository!!.findById(idPregunta)
        }catch (e:Exception){
            throw BusinessException(e.message)
        }

        if(!op.isPresent){
            throw NotFoundException("No se encontro la pregunta con id $idPregunta")
        }

        return  op.get()
    }


    override fun save(pregunta: Pregunta): Pregunta {
        try {
            return preguntaRepository!!.save(pregunta)
        }catch (e:Exception){
            throw BusinessException(e.message)
        }
    }

    override fun remove(idPregunta: Long) {
        val op: Optional<Pregunta>
        try{
            op = preguntaRepository!!.findById(idPregunta)
        }catch (e:Exception){
            throw BusinessException(e.message)
        }

        if(!op.isPresent){
            throw NotFoundException("No se encontro la pregunta con id $idPregunta")
        }
        else{
            try {
                preguntaRepository!!.deleteById(idPregunta)
            }catch (e:Exception){
                throw BusinessException(e.message)
            }
        }
    }
}