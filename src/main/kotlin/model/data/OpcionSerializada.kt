package model.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import javax.persistence.Entity
import javax.persistence.Table


class OpcionSerializada {
    @SerializedName("clave")
    @Expose
    lateinit var clave: String

    @SerializedName("texto")
    @Expose
    lateinit var texto: String

}

