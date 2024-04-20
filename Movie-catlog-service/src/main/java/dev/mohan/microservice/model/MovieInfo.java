package dev.mohan.microservice.model;

public class MovieInfo {

	private String movieId;
	private String movieDesc;
	private String movieName;
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public String getMovieDesc() {
		return movieDesc;
	}
	public void setMovieDesc(String movieDesc) {
		this.movieDesc = movieDesc;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public MovieInfo(String movieId, String movieDesc, String movieName) {
		super();
		this.movieId = movieId;
		this.movieDesc = movieDesc;
		this.movieName = movieName;
	}
	public MovieInfo() {
		super();
	}
	
	
}
