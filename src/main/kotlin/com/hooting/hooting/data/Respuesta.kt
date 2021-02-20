package com.hooting.hooting.data

import org.springframework.lang.NonNull
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id


data class Respuesta(val respuesta: String = "", var isTrue: Boolean = false) {

}
