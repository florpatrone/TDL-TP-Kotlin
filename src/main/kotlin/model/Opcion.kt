package model

import model.data.Respuesta
import model.excepciones.ImposibleConvertirEnRespuestaException

open class Opcion(val clave: String?, val textoOpcion: String?) {

    open fun convertirEnRespuesta(): Respuesta {
        throw ImposibleConvertirEnRespuestaException()
    }

    @JvmName("getClave1")
    fun getClave(): String? {
        return clave
    }

    @JvmName("getTextoOpcion1")
    fun getTextoOpcion(): String? {
        return textoOpcion
    }
}
