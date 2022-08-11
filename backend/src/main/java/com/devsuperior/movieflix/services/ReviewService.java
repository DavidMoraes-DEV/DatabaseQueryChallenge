package com.devsuperior.movieflix.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ReviewRepository;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;

@Service
public class ReviewService {
	
	@Autowired
	private ReviewRepository repository;
	
	@Autowired 
	private MovieRepository movieRepository;
	
	@Transactional(readOnly = true)
	public List<ReviewDTO> findByMovie(Long movieId) {
	
		Optional<Movie> obj = movieRepository.findById(movieId);
		Movie movie = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		List<Review> reviews = movie.getReviews();
		List<ReviewDTO> reviewsDTO = reviews.stream().map(x -> new ReviewDTO(x)).collect(Collectors.toList());
		
		return reviewsDTO;
	}
	
	@Transactional
	public ReviewDTO insert(ReviewDTO reviewDTO) {
		
		Review entity = new Review();
		entity.setId(reviewDTO.getId());
		entity.setText(reviewDTO.getText());
		entity = repository.save(entity);
		
		return new ReviewDTO(entity);
	}
}
