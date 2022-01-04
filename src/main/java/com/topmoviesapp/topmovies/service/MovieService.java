package com.topmoviesapp.topmovies.service;

import com.topmoviesapp.topmovies.model.Genre;
import com.topmoviesapp.topmovies.model.Director;
import com.topmoviesapp.topmovies.model.Movie;
import com.topmoviesapp.topmovies.repository.DirectorRepository;
import com.topmoviesapp.topmovies.repository.GenreRepository;
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
    private GenreRepository genreRepository;
    private GenreService genreService;
    private DirectorRepository directorRepository;
    private DirectorService directorService;
    private static final Logger LOGGER = Logger.getLogger(MovieService.class.getName());

    @Autowired
    public void setMovieRepository(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Autowired
    public void setGenreService(GenreService genreService) {
        this.genreService = genreService;
    }

    @Autowired
    public void setDirectorService(DirectorService directorService) {
        this.directorService = directorService;
    }

    //get all movies
    public List<Movie> getMovies() {
        LOGGER.info("calling getMovies method from service");
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Movie> movies = movieRepository.findByUserProfileId(userDetails.getUser().getUserProfile().getId());
        if (movies.isEmpty()) {
            throw new RuntimeException();//InformationMissingException("movies missing for user with id: " + userDetails.getUser().getUserProfile().getId());
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
            throw new RuntimeException();//InformationMissingException("movie with id " + movieId + " does not exist");
        }
    }

    public Movie createMovie(Movie movieObject) {
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Movie movie = movieRepository.findByUserProfileIdAndTitle(userDetails.getUser().getUserProfile().getId(), movieObject.getTitle());
        if (movie != null) {
            // Include a throw error here
            throw new RuntimeException();
        } else {
            movieObject.setUserProfile(userDetails.getUser().getUserProfile());
            movieObject.setGenre(genreService.getGenre(movieObject.getGenre().getGenreName()));
            movieObject.setDirector(directorService.createDirector(movieObject.getDirector()));
            return movieRepository.save(movieObject);
        }
    }


    public Movie updateMovie(Long movieId, Movie movieObject) {
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Movie movie = movieRepository.findByUserProfileIdAndId(userDetails.getUser().getUserProfile().getId(), movieId);
        if (movie == null) {
            // Include a throw error here
            throw new RuntimeException();
        } else {
            movie.setTitle(movieObject.getTitle());
            movie.setRank(movieObject.getRank());
            movie.setReleaseYear(movieObject.getReleaseYear());
            movie.setGenre(genreService.getGenre(movieObject.getGenre().getGenreName()));
            movie.setDirector(directorService.createDirector(movieObject.getDirector()));
            return movieRepository.save(movie);
        }
    }

    public Director getDirector(Long movieId) {
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Movie movie = movieRepository.findByUserProfileIdAndId(userDetails.getUser().getUserProfile().getId(), movieId);
        if (movie == null) {
            throw new RuntimeException();//InformationMissingException("movies missing for user with id: " + userDetails.getUser().getUserProfile().getId());
        } else {
            return movie.getDirector();
        }
  }

  public Movie deleteMovie(Long movieId) {
        LOGGER.info("calling deleteMovie method from service");
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Movie movie = movieRepository.findByUserProfileIdAndId(userDetails.getUser().getUserProfile().getId(), movieId);
        if (movie == null) {
            throw new RuntimeException();//InformationMissingException("category with id " + categoryId + " does not exist");
        } else {
            movieRepository.deleteById(movieId);
            return movie;
        }
    }
}
