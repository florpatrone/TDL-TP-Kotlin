package model.data

class OpcionSerializada {

    //@SerializedName("clave")
    //@Expose
    private val clave: String? = null

    //@SerializedName("texto")
    //@Expose
    private val texto: String? = null

    fun getClave(): String? {
        return clave
    }


    fun getTexto(): String? {
        return texto
    }
}

