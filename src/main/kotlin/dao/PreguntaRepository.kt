package dao

import model.data.Pregunta
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PreguntaRepository: JpaRepository<Pregunta, Long> {

}