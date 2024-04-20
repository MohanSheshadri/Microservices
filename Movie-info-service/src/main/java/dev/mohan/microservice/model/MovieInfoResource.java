package dev.mohan.microservice.model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movieInfo")
public class MovieInfoResource {

	
	@GetMapping("/{movieId}")
	public MovieInfo getMovieInfo(@PathVariable(value="movieId") String movieId) {
		
		return new MovieInfo(movieId, "Real Story", "October Sky");
	}
	
	
}
