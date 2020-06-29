package pl.dmcs.helloworldspring

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

const val PATH_SLASH = "/"
const val PATH_ID = "/{id}"
const val PATH_INIT = "/init"

@RestController
class PersonController(private val service: PersonService) {


    @PostMapping(path = [PATH_INIT])
    fun initData(@RequestBody data: List<Person>) {
        return service.fillData(data)
    }

    @GetMapping(path = [PATH_ID])
    fun getSinglePersonMethod(@PathVariable id: Int): ResponseEntity<Person> {
        return service.findById(id)
    }

    @GetMapping(path = [PATH_SLASH])
    fun getPersonsMethod(): ResponseEntity<List<Person>> {
        return service.getAll()
    }

    @PostMapping(path = [PATH_SLASH])
    fun postMethod(@RequestBody person: Person): ResponseEntity<Person> {
        return service.insert(person)
    }

    @PutMapping(path = [PATH_ID])
    fun putMethod(@PathVariable id: Int, @RequestBody person: Person): ResponseEntity<Person> {
        return service.update(id, person)
    }

    @DeleteMapping(path = [PATH_ID])
    fun deleteMethod(@PathVariable id: Int): ResponseEntity<Boolean> {
        return service.delete(id)
    }

}