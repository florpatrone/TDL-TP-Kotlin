package com.Hoot.hoot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HootApplication

fun main(args: Array<String>) {
	runApplication<HootApplication>(*args)
}
