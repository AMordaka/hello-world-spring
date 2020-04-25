package pl.dmcs.helloworldspring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HelloWorldSpringApplication

fun main(args: Array<String>) {
	runApplication<HelloWorldSpringApplication>(*args)
}
