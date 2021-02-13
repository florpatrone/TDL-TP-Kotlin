package model.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class OpcionSerializada {
    @SerializedName("clave")
    @Expose
    lateinit var clave: String

    @SerializedName("texto")
    @Expose
    lateinit var texto: String

    @JvmName("getClave1")
    fun getClave(): String{
        return clave
    }

    @JvmName("getTexto1")
    fun getTexto(): String{
        return texto
    }
}

