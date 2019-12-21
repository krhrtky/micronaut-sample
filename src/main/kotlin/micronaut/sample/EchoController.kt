package micronaut.sample

import io.micronaut.context.annotation.Parameter
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import micronaut.sample.person.Person
import micronaut.sample.person.PersonService
import javax.inject.Inject

@Controller("/echo")
class EchoController(@Inject val personService: PersonService) {

    @Get("/")
    fun index() = HttpStatus.OK

    @Get("/person")
    fun person(@Parameter(value = "name") name: String, @Parameter(value = "age") age: Int): HttpResponse<Person>
            = HttpResponse.created(Person(name, age))

    @Get("/person/{id}")
    fun find(@PathVariable(value = "id") id: Int) = personService.findById(id)

}
