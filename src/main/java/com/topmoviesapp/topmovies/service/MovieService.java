package com.topmoviesapp.topmovies.service;

import com.topmoviesapp.topmovies.model.Movie;
import com.topmoviesapp.topmovies.repository.DirectorRepository;
import com.topmoviesapp.topmovies.repository.GenreRepository;
import com.topmoviesapp.topmovies.repository.MovieRepository;
import com.topmoviesapp.topmovies.security.MyUserDetails;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    private MovieRepository movieRepository;
    private GenreRepository genreRepository;
    private DirectorRepository directorRepository;

    public Movie createMovie(Movie movieObject) {
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Movie movie = movieRepository.findByUserProfileIdAndTitle(userDetails.getUser().getUserProfile().getId(), movieObject.getTitle());
        if(movie != null){
            // Include a throw error here
            throw new RuntimeException();
        } else {
            movieObject.setUserProfile(userDetails.getUser().getUserProfile());
            return movieRepository.save(movieObject);
        }
    }
}
