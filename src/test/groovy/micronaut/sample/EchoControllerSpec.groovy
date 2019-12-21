package micronaut.sample

import io.micronaut.http.client.annotation.Client
import io.micronaut.runtime.server.EmbeddedServer
import io.micronaut.test.annotation.MicronautTest
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import spock.lang.AutoCleanup
import spock.lang.Specification
import spock.lang.Shared

import javax.inject.Inject

@MicronautTest
class EchoControllerSpec extends Specification {

    @Shared @Inject
    EmbeddedServer embeddedServer

    @Shared @AutoCleanup @Inject @Client("/")
    RxHttpClient client

    void "test index"() {

        given:
        HttpResponse response = client.toBlocking().exchange("/echo")

        expect:
        response.status == HttpStatus.OK
    }

    void "test path person"() {

        given:
        HttpResponse response = client.toBlocking().exchange("/echo/person?name=hoge&age=1")

        println response.getBody()

        expect:
        response.status == HttpStatus.CREATED

    }
}
