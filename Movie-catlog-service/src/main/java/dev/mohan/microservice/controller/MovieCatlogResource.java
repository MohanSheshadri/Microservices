package dev.mohan.microservice.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import dev.mohan.microservice.model.CatologItem;
import dev.mohan.microservice.model.MovieInfo;

@RestController
@RequestMapping("/catalog")
public class MovieCatlogResource {

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	WebClient.Builder webclientBuilder;
	
	@GetMapping(value={"/all","/{id}"})
	public List<CatologItem> getcatologDetails(@PathVariable(required=false, value="id") String userId){
		
		//Resttemplate // will be depricated in near future
		MovieInfo movieObj = restTemplate.getForObject("http://movie-info-service/movieInfo/123", MovieInfo.class);
		
		//Webcient is part of asynchromnus react programming -part of spring.webflux library
//		MovieInfo movieObj = webclientBuilder
//				.build() // instance has to be build
//				.get() // method type i.e get post put delete
//				.uri("http://localhost:9020/movieInfo/123") // url
//				.retrieve() // retrive obj
//				.bodyToMono(MovieInfo.class) //getBody and Mono means acts like proomise go continue with other work
//				.block(); // till then block the next steps
			return Collections.singletonList(new CatologItem(userId, movieObj.getMovieName(), "5"));		
	}
	
}
