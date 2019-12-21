package micronaut.sample.person

import io.micronaut.context.annotation.Context

@Context
class PersonServiceImpl : PersonService {
    override fun findById(id: Int) = Person("name${id}", id + 10)

}
