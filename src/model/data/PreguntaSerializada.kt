package model.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class PreguntaSerializada {
    @SerializedName("type")
    @Expose
    lateinit var type: String

    @SerializedName("enunciado")
    @Expose
    lateinit var enunciado: String

    @SerializedName("options")
    @Expose
    lateinit var options: List<OpcionSerializada>

    @SerializedName("puntaje_type")
    @Expose
    lateinit var puntajeType: String

    //-----------------------------------------------------------------------------------------------------------
    @JvmName("getType1")
    fun getType(): String{
        return type
    }

    @JvmName("getEnunciado1")
    fun getEnunciado(): String{
        return enunciado
    }
    @JvmName("setEnunciado1")
    fun setEnunciado(enunciado: String){
        this.enunciado = enunciado
    }

    @JvmName("getOptions1")
    fun getOptions(): List<OpcionSerializada>{
        return options
    }

    @JvmName("getPuntajeType1")
    fun getPuntajeType(): String{
        return puntajeType
    }
}