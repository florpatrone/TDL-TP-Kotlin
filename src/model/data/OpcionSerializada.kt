package model.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class OpcionSerializada {
    @SerializedName("clave")
    @Expose
    val clave: String? = null

    @SerializedName("texto")
    @Expose
    val texto: String? = null

    @JvmName("getClave1")
    fun getClave(): String? {
        return clave
    }

    @JvmName("getTexto1")
    fun getTexto(): String? {
        return texto
    }
}

