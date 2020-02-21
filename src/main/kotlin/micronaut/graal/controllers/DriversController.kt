package micronaut.graal.controllers

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import micronaut.graal.model.Driver
import micronaut.graal.repository.DriverRepository
import javax.inject.Inject

/**
 * @author vinicius
 *
 */
@Controller("/drivers")
class DriversController {

	@Inject
	lateinit var driverRepository: DriverRepository

	@Get("/{id}")
	fun getDriver(@PathVariable id: Int) : Driver {
		return driverRepository.findById(id).get()
	}
}