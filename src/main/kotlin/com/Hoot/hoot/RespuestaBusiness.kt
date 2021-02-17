package com.Hoot.hoot

import dao.RespuestaRepository
import javassist.NotFoundException
import model.data.Respuesta
import model.excepciones.BusinessException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import kotlin.jvm.Throws

@Service
class respuestaBusiness: IRespuestaBusiness {

    @Autowired
    val respuestaRepository : RespuestaRepository? = null

    @Throws(BusinessException::class)
    override fun list(): List<Respuesta> {
        try{
            return respuestaRepository!!.findAll()
        }catch (e: Exception){
            throw BusinessException(e.message)
        }
    }

    @Throws(BusinessException::class, NotFoundException::class)
    override fun load(idrespuesta: Long): Respuesta {
        val op: Optional<Respuesta>
        try{
            op = respuestaRepository!!.findById(idrespuesta)
        }catch (e:Exception){
            throw BusinessException(e.message)
        }

        if(!op.isPresent){
            throw NotFoundException("No se encontro la respuesta con id $idrespuesta")
        }

        return  op.get()
    }


    override fun save(respuesta: Respuesta): Respuesta {
        try {
            return respuestaRepository!!.save(respuesta)
        }catch (e:Exception){
            throw BusinessException(e.message)
        }
    }

    override fun remove(idrespuesta: Long) {
        val op: Optional<Respuesta>
        try{
            op = respuestaRepository!!.findById(idrespuesta)
        }catch (e:Exception){
            throw BusinessException(e.message)
        }

        if(!op.isPresent){
            throw NotFoundException("No se encontro la respuesta con id $idrespuesta")
        }
        else{
            try {
                respuestaRepository!!.deleteById(idrespuesta)
            }catch (e:Exception){
                throw BusinessException(e.message)
            }
        }
    }
}