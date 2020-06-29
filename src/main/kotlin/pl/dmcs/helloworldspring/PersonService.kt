package pl.dmcs.helloworldspring

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

interface PersonService {
    fun fillData(data: List<Person>)
    fun update(id: Int, person: Person): ResponseEntity<Person>
    fun insert(person: Person): ResponseEntity<Person>
    fun findById(id: Int): ResponseEntity<Person>
    fun delete(id: Int): ResponseEntity<Boolean>
    fun getAll(): ResponseEntity<List<Person>>
}

@Service
class PersonServiceImpl(private val repository: PersonRepository) : PersonService {

    override fun fillData(data: List<Person>) {
        repository.fill(data)
    }

    override fun update(id: Int, person: Person): ResponseEntity<Person> {
        return ResponseEntity.ok(repository.update(id, person))
    }

    override fun insert(person: Person): ResponseEntity<Person> {
        return ResponseEntity.ok(repository.insert(person))
    }

    override fun findById(id: Int): ResponseEntity<Person> {
        val person = repository.findById(id) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(person)
    }

    override fun delete(id: Int): ResponseEntity<Boolean> {
        return ResponseEntity.ok(repository.delete(id))
    }

    override fun getAll(): ResponseEntity<List<Person>> {
        return ResponseEntity.ok(repository.getAll())
    }

}


