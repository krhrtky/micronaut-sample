package micronaut.sample

import io.micronaut.context.annotation.Parameter
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/echo")
class EchoController {

    @Get("/")
    fun index() = HttpStatus.OK

    @Get("/person")
    fun person(@Parameter(value = "name") name: String, @Parameter(value = "age") age: Int): HttpResponse<Person>
            = HttpResponse.created(Person(name, age))

}
