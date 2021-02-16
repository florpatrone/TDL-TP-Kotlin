package web

import com.Hoot.hoot.IPreguntaBusiness
import javassist.NotFoundException
import model.Pregunta
import model.excepciones.BusinessException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import util.Constantes
import java.lang.Exception


@RestController

@RequestMapping(Constantes.URL_BASE_PREGUNTAS)
class PreguntaRestController {

    @Autowired
    val preguntaBusiness: IPreguntaBusiness? = null

    @GetMapping("")
    fun list():ResponseEntity<List<Pregunta>>{
        return try {
            ResponseEntity(preguntaBusiness!!.list(), HttpStatus.OK)
        }catch (e:Exception){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @GetMapping("/{id}")
    fun load(@PathVariable("id") idPregunta:Long): ResponseEntity<Pregunta>{
        return try{
            ResponseEntity(preguntaBusiness!!.load(idPregunta), HttpStatus.OK)
        }catch (e:BusinessException){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }catch (e: NotFoundException){
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @PostMapping("")
    fun insert(@RequestBody pregunta: Pregunta): ResponseEntity<Any>{

        return try{
            preguntaBusiness!!.save(pregunta)
            val responseHeader = HttpHeaders()
            responseHeader.set("location", Constantes.URL_BASE_PREGUNTAS + "/" /* + Pregunta.id*/)
            ResponseEntity(responseHeader, HttpStatus.CREATED)
        }catch (e: BusinessException){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @PutMapping
    fun update(@RequestBody pregunta: Pregunta): ResponseEntity<Any>{
        return try{
            preguntaBusiness!!.save(pregunta)
            ResponseEntity(HttpStatus.OK)
        }catch(e: BusinessException){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @DeleteMapping("/{id}")

    fun delete(@PathVariable("id") idPregunta: Long): ResponseEntity<Any>{
        return try{
            preguntaBusiness!!.remove(idPregunta)
            ResponseEntity(HttpStatus.OK)
        }catch (e:BusinessException){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }catch (e: NotFoundException){
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }




}