package micronaut.graal

import com.google.cloud.sql.postgres.SocketFactory
import io.micronaut.core.annotation.TypeHint
import io.micronaut.runtime.Micronaut

@TypeHint(value = [org.postgresql.Driver::class, SocketFactory::class])
object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("micronaut.graal")
                .mainClass(Application.javaClass)
                .start()
    }
}