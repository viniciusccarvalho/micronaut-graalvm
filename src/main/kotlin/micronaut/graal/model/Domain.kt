package micronaut.graal.model

import io.micronaut.core.annotation.Introspected
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

/**
 * @author vinicius
 *
 */

@Introspected
@Entity
@Table(name="drivers")
data class Driver(@Id @Column(name = "driverId") var id: Int,
				  @Column(name = "driverRef") var reference: String,
				  var number: Int? = null,
				  var code: String? = null,
				  var forename: String,
				  var surname: String,
				  var nationality: String,
				  var url: String? = null,
				  var dob: String? = null)