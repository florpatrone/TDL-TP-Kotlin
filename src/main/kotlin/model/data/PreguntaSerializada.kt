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

}