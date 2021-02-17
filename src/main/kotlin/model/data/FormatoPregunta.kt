package model.data

import javax.persistence.*

@Entity
@Table
data class FormatoPregunta(val tipoPregunta : String = "",
                           val enunciado : String = "",
                           val respuestasCorrectas : Array<String>,
                           val opciones : Array<String> ) {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id : Long = 0
}