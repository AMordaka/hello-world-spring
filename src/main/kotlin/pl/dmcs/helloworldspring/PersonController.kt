package pl.dmcs.helloworldspring

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

const val PATH_SLASH = "/"

@RestController
class PersonController(private val service: PersonService) {


    @PostMapping(path = [PATH_SLASH])
    fun initData(@RequestBody data: List<Person>): ResponseEntity<List<Person>> {
        return service.fillData(data)
    }

    @GetMapping(path = [PATH_SLASH])
    fun getPersonsMethod(): ResponseEntity<List<Person>> {
        return service.getAll()
    }

    @PutMapping(path = [PATH_SLASH])
    fun putMethod(@RequestBody data: List<Person>): ResponseEntity<List<Person>> {
        return service.fillData(data)
    }

    @DeleteMapping(path = [PATH_SLASH])
    fun deleteMethod(): ResponseEntity<Boolean> {
        return service.delete()
    }

}
