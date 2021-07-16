package abhi.beerframework.resttemplate.MSSCBreweryClient.breweries.client;

import java.net.URI;
import java.util.UUID;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import abhi.beerframework.resttemplate.MSSCBreweryClient.breweries.models.CustomerDto;

@Component
@ConfigurationProperties(value = "sfg.customer", ignoreUnknownFields = false)
public class CustomerClient {
	
	private final String CUSTOMER_PATH_V1 = "/customerServiceApi/v1/customer/";
	
	private String apiHost;
	
	private final RestTemplate restTemplate;

	public CustomerClient(RestTemplateBuilder restTemplateBuilder) {
		super();
		this.restTemplate = restTemplateBuilder.build();
	}
	
	
	public CustomerDto getCustomerById(UUID customerId) {
		
		return restTemplate.getForObject(apiHost + CUSTOMER_PATH_V1 + "/" + customerId.toString(), CustomerDto.class);
	}
	
	public URI saveNewCustomer(CustomerDto customerDto) {
		
		return restTemplate.postForLocation(apiHost + CUSTOMER_PATH_V1, customerDto);
	}
	
	public void updateCustomerById(UUID customerId, CustomerDto customerDto) {
		
		restTemplate.put(apiHost + CUSTOMER_PATH_V1 + "/" + customerId.toString(), customerDto);
	}
	
	public void deleteCustomer(UUID customerId) {
		
		restTemplate.delete(apiHost + CUSTOMER_PATH_V1 + "/" + customerId);
	}


	public void setApiHost(String apiHost) {
		this.apiHost = apiHost;
	}

}
