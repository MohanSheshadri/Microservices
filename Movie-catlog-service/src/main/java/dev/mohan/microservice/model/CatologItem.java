package dev.mohan.microservice.model;

public class CatologItem {

	private String userId;
	private String movieName;
	private String rating;
	public CatologItem(String userId, String movieName, String rating) {
		super();
		this.userId = userId;
		this.movieName = movieName;
		this.rating = rating;
	}
	public CatologItem() {
		super();
	}
	public String getUserId() {
		return userId;
	}
	public String getMovieName() {
		return movieName;
	}
	public String getRating() {
		return rating;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	
	
	
	
}
