package dev.mohan.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
//import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MovieCatalogService {

	
	//In order to have a timeout at service level if threads are piled up and its hampering the service performanec // brutfull source not recomended
	@Bean
	@LoadBalanced
	public RestTemplate getResttemplate() {
//		HttpComponentsClientHttpRequestFactory httpRequest = 
//				new HttpComponentsClientHttpRequestFactory();
//		httpRequest.setConnectTimeout(3000);
		return new RestTemplate();
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(MovieCatalogService.class, args);
	}

}
