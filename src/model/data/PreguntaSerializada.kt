package model.data

class PreguntaSerializada {

    //@SerializedName("type")
    //@Expose
    private val type: String? = null

    //@SerializedName("enunciado")
    //@Expose
    private var enunciado: String? = null

    //@SerializedName("options")
    //@Expose
    private val options: List<OpcionSerializada?>? = null

    //@SerializedName("puntaje_type")
    //@Expose
    private val puntajeType: String? = null

    fun getType(): String? {
        return type
    }


    fun getEnunciado(): String? {
        return enunciado
    }

    fun setEnunciado(enunciado: String?) {
        this.enunciado = enunciado
    }


    fun getOptions(): List<OpcionSerializada?>? {
        return options
    }


    fun getPuntajeType(): String? {
        return puntajeType
    }


}