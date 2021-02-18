package com.Hoot.hoot.business

import com.hooting.hooting.business.IRespuestaBusiness
import com.hooting.hooting.dao.RespuestaRepository
import com.hooting.hooting.data.Respuesta
import com.hooting.hooting.excepciones.BusinessException
import com.hooting.hooting.excepciones.NotFoundException
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