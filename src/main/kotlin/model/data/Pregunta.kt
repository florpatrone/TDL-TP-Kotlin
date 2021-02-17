package model.data

import javax.persistence.*

@Entity
@Table
data class Pregunta(val tipoPregunta : String = "",
                    val enunciado : String = "") {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id : Long = 0
}