package eespinor.product

import kotlinx.coroutines.flow.count
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ProductApplicationTests (
	@Autowired val customerRepository: CustomerRepository
) {

	@Test
	fun contextLoads() {
		runBlocking {
			val customers = customerRepository.findAll()
			customerRepository.save(Customer(null, "Hadi"))

			Assertions.assertEquals(7, customers.count())
		}
	}

}
