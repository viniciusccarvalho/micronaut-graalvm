package micronaut.graal

import io.micronaut.core.annotation.TypeHint
import io.micronaut.runtime.Micronaut
import org.mariadb.connection.SocketFactory

@TypeHint(value = [
    SocketFactory::class,
    org.mariadb.jdbc.util.Options::class,
    org.mariadb.jdbc.Driver::class ]
,
        accessType = [ TypeHint.AccessType.ALL_PUBLIC ])
object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("micronaut.graal")
                .mainClass(Application.javaClass)
                .start()
    }
}