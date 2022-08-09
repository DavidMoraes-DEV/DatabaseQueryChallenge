package com.devsuperior.movieflix.dto;

import java.util.Objects;

import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.User;

public class ReviewDTO {

	private Long id;
	
	private String text;
	
	public ReviewDTO() {		
	}

	public ReviewDTO(Long id, String text, User user) {
		this.id = id;
		this.text = text;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReviewDTO other = (ReviewDTO) obj;
		return Objects.equals(id, other.id);
	}
}
