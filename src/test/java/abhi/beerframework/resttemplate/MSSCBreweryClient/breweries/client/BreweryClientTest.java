package abhi.beerframework.resttemplate.MSSCBreweryClient.breweries.client;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.net.URI;
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
	
	@Test
	public void testSaveNewBeer() {
		//given
		BeerDto beerDto = BeerDto.builder().beerName("Carlsberg").build();
		
		URI uri = breweryClient.saveNewBeer(beerDto);
		
		assertNotNull(uri);
		
		System.out.println("URI for new beer " + uri.toString());
	}
	
	@Test
	public void testUpdateBeer() {
		//given
		BeerDto beerDto = BeerDto.builder().beerName("Kingfisher").build();
		
		breweryClient.updateBeer(UUID.randomUUID(), beerDto);
		
		
	}
	
	
}
