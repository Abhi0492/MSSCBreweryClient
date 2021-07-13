package abhi.beerframework.resttemplate.MSSCBreweryClient.breweries.client;

import java.util.UUID;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import abhi.beerframework.resttemplate.MSSCBreweryClient.breweries.models.BeerDto;

@Component
@ConfigurationProperties(value = "sfg.brewery", ignoreUnknownFields = false)
public class BreweryClient {
	
	public final String BEER_PATH = "/beerServiceApi/v1/beer/";
	
	private String apiHost;
	
	private final RestTemplate restTemplate;

	
	public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
		super();
		this.restTemplate = restTemplateBuilder.build();
	}
	
	public BeerDto getBeerById(UUID beerId) {
		
		return restTemplate.getForObject(apiHost + BEER_PATH + beerId.toString(), BeerDto.class);
	}
	
	public void setApiHost(String apiHost) {
		this.apiHost = apiHost;
	}


}
