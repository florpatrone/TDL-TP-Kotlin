package model

class OpcionConjunto : Opcion {
    var claveElegida: String? = null
        private set

    constructor(clave: String?, textoOpcion: String?) : super(clave!!, textoOpcion!!) {}
    constructor(clave: String?, textoOpcion: String?, claveElegida: String?) : super(
        clave!!,
        textoOpcion!!
    ) {
        this.claveElegida = claveElegida
    }

    constructor(opcionOriginal: Opcion, claveElegida: String?) : super(
        opcionOriginal.clave,
        opcionOriginal.textoOpcion
    ) {
        this.claveElegida = claveElegida
    }

    override fun convertirEnRespuesta(): Respuesta {
        return if (claveElegida == super.clave) RespuestaCorrecta("Correcta") else RespuestaIncorrecta("Incorrecta")
    }
}