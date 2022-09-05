package io.spring.batch.springbatchwithkotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringBatchWithKotlinApplication

fun main(args: Array<String>) {
    runApplication<SpringBatchWithKotlinApplication>(*args)
}
