package micronaut.graal.repository

import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.repository.CrudRepository
import micronaut.graal.model.Driver

/**
 * @author vinicius
 *
 */
@JdbcRepository(dialect = Dialect.MYSQL)
interface DriverRepository : CrudRepository<Driver, Int> {
}