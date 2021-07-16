package abhi.beerframework.resttemplate.MSSCBreweryClient.breweries.client;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.net.URI;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import abhi.beerframework.resttemplate.MSSCBreweryClient.breweries.models.CustomerDto;

@SpringBootTest
public class CustomerClientTest {
	
	@Autowired
	CustomerClient customerClient;
	
	@Test
	public void testGetCustomer() {
		
		CustomerDto customerDto = customerClient.getCustomerById(UUID.randomUUID());
		
		assertNotNull(customerDto);
	}
	
	@Test
	public void testSaveCustomer() {
		
		CustomerDto customerDto = CustomerDto.builder().customerName("Asha Seshadri").build();
		
		URI uri =  customerClient.saveNewCustomer(customerDto);
		
		assertNotNull(uri);
	}
	
	@Test
	public void testUpdateCustomer() {
		
		CustomerDto customerDto = CustomerDto.builder().customerName("Seshadri P Iyer").build();
		
		customerClient.updateCustomerById(UUID.randomUUID(), customerDto);
		
	}
	
	@Test
	public void testDeleteCustomer() {
		
		customerClient.deleteCustomer(UUID.randomUUID());
	}
	

}
