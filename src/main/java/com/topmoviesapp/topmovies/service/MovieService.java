package com.topmoviesapp.topmovies.service;

import com.topmoviesapp.topmovies.model.Movie;
import com.topmoviesapp.topmovies.repository.MovieRepository;
import com.topmoviesapp.topmovies.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class MovieService {
    private MovieRepository movieRepository;
    private static final Logger LOGGER = Logger.getLogger(MovieService.class.getName());

    @Autowired
    public void setMovieRepository(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    //get all movies
    public List<Movie> getMovies() {
        LOGGER.info("calling getMovies method from service");
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Movie> movies = movieRepository.findByUserProfileId(userDetails.getUser().getUserProfile().getId());
        if (movies.isEmpty()) {
            throw new InformationMissingException("movies missing for user with id: " + userDetails.getUser().getUserProfile().getId());
        } else {
            return movies;
        }
    }

    //get single movie
    public Movie getMovie(Long movieId) {
        LOGGER.info("calling getMovie method from service");
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Movie movie = movieRepository.findByUserProfileIdAndId(userDetails.getUser().getUserProfile().getId(), movieId);
        if (movie != null) {
            return movie;
        } else {
            throw new InformationMissingException("movie with id " + movieId + " does not exist");
        }
    }
}
