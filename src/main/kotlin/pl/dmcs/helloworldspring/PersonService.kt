package pl.dmcs.helloworldspring

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

interface PersonService {
    fun fillData(data: List<Person>): ResponseEntity<List<Person>>
    fun delete(): ResponseEntity<Boolean>
    fun getAll(): ResponseEntity<List<Person>>
}

@Service
class PersonServiceImpl(private val repository: PersonRepository) : PersonService {

    override fun fillData(data: List<Person>): ResponseEntity<List<Person>> {
        return ResponseEntity.ok(repository.fill(data))
    }

    override fun delete(): ResponseEntity<Boolean> {
        return ResponseEntity.ok(repository.delete())
    }

    override fun getAll(): ResponseEntity<List<Person>> {
        return ResponseEntity.ok(repository.getAll())
    }

}


