package com.hooting.hooting.data

import org.springframework.lang.NonNull
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Respuesta() {
    @Id
    @GeneratedValue
    @NonNull
    val id: Long = 0
    val respuesta: String = ""
    val id_pregunta: Long = 0
    val isTrue: Boolean = false

}
