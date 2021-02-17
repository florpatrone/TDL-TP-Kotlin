package dao

import model.Pregunta
import model.data.FormatoPregunta
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PreguntaRepository: JpaRepository<FormatoPregunta, Long> {

}