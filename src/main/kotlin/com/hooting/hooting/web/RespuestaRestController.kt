package com.hooting.hooting.web

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import com.hooting.hooting.business.IRespuestaBusiness
import com.hooting.hooting.data.Respuesta
import com.hooting.hooting.excepciones.BusinessException
import com.hooting.hooting.excepciones.NotFoundException
import com.hooting.hooting.util.Constantes
import org.springframework.beans.factory.annotation.Autowired
import java.lang.Exception


@RestController

@RequestMapping(Constantes.URL_BASE_RESPUESTAS)
class RespuestaRestController {

    @Autowired
    val respuestaBusiness: IRespuestaBusiness? = null

    @GetMapping("")
    fun list():ResponseEntity<List<Respuesta>>{
        return try {
            ResponseEntity(respuestaBusiness!!.list(), HttpStatus.OK)
        }catch (e:Exception){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @GetMapping("/{id}")
    fun load(@PathVariable("id") idRespuesta:Long): ResponseEntity<Respuesta>{
        return try{
            ResponseEntity(respuestaBusiness!!.load(idRespuesta), HttpStatus.OK)
        }catch (e: BusinessException){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }catch (e: NotFoundException){
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @PostMapping("")
    fun insert(@RequestBody respuesta: Respuesta): ResponseEntity<Any>{

        return try{
            respuestaBusiness!!.save(respuesta)
            val responseHeader = HttpHeaders()
            responseHeader.set("location", Constantes.URL_BASE_RESPUESTAS + "/" /* + Respuesta.id*/)
            ResponseEntity(responseHeader, HttpStatus.CREATED)
        }catch (e: BusinessException){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @PutMapping
    fun update(@RequestBody respuesta: Respuesta): ResponseEntity<Any>{
        return try{
            respuestaBusiness!!.save(respuesta)
            ResponseEntity(HttpStatus.OK)
        }catch(e: BusinessException){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @DeleteMapping("/{id}")

    fun delete(@PathVariable("id") idRespuesta: Long): ResponseEntity<Any>{
        return try{
            respuestaBusiness!!.remove(idRespuesta)
            ResponseEntity(HttpStatus.OK)
        }catch (e:BusinessException){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }catch (e: NotFoundException){
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }
}