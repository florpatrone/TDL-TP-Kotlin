package model

import model.excepciones.ImposibleConvertirEnRespuestaException

class Opcion(val clave: String, val textoOpcion: String) {

    fun convertirEnRespuesta(): Respuesta {
        throw ImposibleConvertirEnRespuestaException()
    }
}
