package com.hooting.hooting.dao

import com.hooting.hooting.data.Respuesta
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RespuestaRepository: JpaRepository<Respuesta, Long> {

}