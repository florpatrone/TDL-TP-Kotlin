package com.Hoot.hoot

import dao.PreguntaRepository
import javassist.NotFoundException
import model.Pregunta
import model.data.FormatoPregunta
import model.excepciones.BusinessException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import kotlin.jvm.Throws

@Service
class PreguntaBusiness: IPreguntaBusiness {

    @Autowired
    val preguntaRepository : PreguntaRepository? = null

    @Throws(BusinessException::class)
    override fun list(): List<FormatoPregunta> {
        try{
            return preguntaRepository!!.findAll()
        }catch (e: Exception){
            throw BusinessException(e.message)
        }
    }

    @Throws(BusinessException::class, NotFoundException::class)
    override fun load(idPregunta: Long): FormatoPregunta {
        val op: Optional<FormatoPregunta>
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


    override fun save(pregunta: FormatoPregunta): FormatoPregunta {
        try {
            return preguntaRepository!!.save(pregunta)
        }catch (e:Exception){
            throw BusinessException(e.message)
        }
    }

    override fun remove(idPregunta: Long) {
        val op: Optional<FormatoPregunta>
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