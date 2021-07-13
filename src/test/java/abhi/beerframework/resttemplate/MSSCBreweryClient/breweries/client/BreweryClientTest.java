package abhi.beerframework.resttemplate.MSSCBreweryClient.breweries.client;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import abhi.beerframework.resttemplate.MSSCBreweryClient.breweries.models.BeerDto;

@SpringBootTest
public class BreweryClientTest {
	
	@Autowired
	BreweryClient breweryClient;

	@Test
	public void getBeerById() {
		
		BeerDto dto = breweryClient.getBeerById(UUID.randomUUID());
		
		assertNotNull(dto);
		
	}
	
	
}
