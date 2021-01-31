package model.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class PreguntaSerializada {
    @SerializedName("type")
    @Expose
    val type: String? = null

    @SerializedName("enunciado")
    @Expose
    var enunciado: String? = null

    @SerializedName("options")
    @Expose
    val options: List<OpcionSerializada>? = null

    @SerializedName("puntaje_type")
    @Expose
    val puntajeType: String? = null

    @JvmName("getType1")
    fun getType(): String? {
        return type
    }

    @JvmName("getEnunciado1")
    fun getEnunciado(): String? {
        return enunciado
    }
    @JvmName("setEnunciado1")
    fun setEnunciado(enunciado: String?) {
        this.enunciado = enunciado
    }

    @JvmName("getOptions1")
    fun getOptions(): List<OpcionSerializada?>? {
        return options
    }

    @JvmName("getPuntajeType1")
    fun getPuntajeType(): String? {
        return puntajeType
    }
}