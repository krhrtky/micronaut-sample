package micronaut.sample.person

interface PersonService {
    fun findById(id: Int): Person
}
