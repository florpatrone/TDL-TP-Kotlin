package com.hooting.hooting.web

import com.hooting.hooting.business.PreguntaService
import com.hooting.hooting.excepciones.BusinessException
import com.hooting.hooting.data.Pregunta
import com.hooting.hooting.excepciones.NotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import com.hooting.hooting.util.Constantes
import java.lang.Exception


@RestController
@RequestMapping(Constantes.URL_BASE_PREGUNTAS)
class PreguntaRestController {

    @Autowired
    val preguntaService: PreguntaService = PreguntaService()


    @GetMapping("")
    fun list():ResponseEntity<List<Pregunta>>{
        return try {
            ResponseEntity(preguntaService!!.listPreguntas(), HttpStatus.OK)
        }catch (e:Exception){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @GetMapping("/{id}")
    fun load(@PathVariable("id") idPregunta:Long): ResponseEntity<Pregunta>{
        return try{
            ResponseEntity(preguntaService!!.getPreguntaDetails(idPregunta), HttpStatus.OK)
        }catch (e: BusinessException){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }catch (e: NotFoundException){
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }
/*
    @PostMapping("")
    fun insert(@RequestBody pregunta: Pregunta): ResponseEntity<Any>{

        return try{
            preguntaService!!.save(pregunta)
            val responseHeader = HttpHeaders()
            responseHeader.set("location", Constantes.URL_BASE_PREGUNTAS + "/" + pregunta.id)
            ResponseEntity(responseHeader, HttpStatus.CREATED)
        }catch (e: BusinessException){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @PutMapping
    fun update(@RequestBody pregunta: Pregunta): ResponseEntity<Any>{
        return try{
            preguntaService!!.save(pregunta)
            ResponseEntity(HttpStatus.OK)
        }catch(e: BusinessException){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @DeleteMapping("/{id}")

    fun delete(@PathVariable("id") idPregunta: Long): ResponseEntity<Any>{
        return try{
            preguntaService!!.remove(idPregunta)
            ResponseEntity(HttpStatus.OK)
        }catch (e:BusinessException){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }catch (e: NotFoundException){
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }*/
}