package com.topmoviesapp.topmovies.controller;

import com.topmoviesapp.topmovies.model.Director;
import com.topmoviesapp.topmovies.model.Genre;
import com.topmoviesapp.topmovies.model.Movie;
import com.topmoviesapp.topmovies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;


@RestController
@RequestMapping(path = "/api")
public class MovieController {

    private static final Logger LOGGER = Logger.getLogger(MovieController.class.getName());
    private MovieService movieService;

    @Autowired
    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }

    // http://localhost:9092/api/movies
    @GetMapping("/movies")
    public List<Movie> getMovies() {
        LOGGER.info("calling getMovies method from controller");
        return movieService.getMovies();
    }

    // http://localhost:9092/api/movies/"{movieId}"
    @GetMapping(path = "/movies/{movieId}")
    public Movie getMovie(@PathVariable Long movieId) {
        LOGGER.info("calling getMovie method from controller");
        return movieService.getMovie(movieId);
    }

    // http://localhost:9092/api/movies/
    @PostMapping("/movies")
    public Movie createMovie(@RequestBody Movie movie) {
        LOGGER.info("calling createMovie method from controller");
        return movieService.createMovie(movie);
    }

    // http://localhost:9092/api/movies/{movie-id}
    @PutMapping("/movies/{movieId}")
    public Movie updateMovie(@PathVariable Long movieId, @RequestBody Movie movieObject) {
        LOGGER.info("calling updateMovie method from controller");
        return movieService.updateMovie(movieId, movieObject);
    }

    // http://localhost:9092/api/movies/{movie-id}/director
    @GetMapping("/movies/{movieId}/director")
    public Director getDirector(@PathVariable Long movieId) {
        LOGGER.info("calling getDirector method from controller");
        return movieService.getDirector(movieId);
    }

    // http://localhost:9092/api/movies/{movie-id}/genre
    @GetMapping("/movies/{movieId}/genre")
    public Genre getGenre(@PathVariable Long movieId) {
        LOGGER.info("calling getGenre method from controller");
        return movieService.getGenre(movieId);
    }

    // http://localhost:9092/api/movies/"{movieId}"
    @DeleteMapping(path = "/movies/{movieId}")
    public Movie deleteMovie(@PathVariable(value = "movieId") Long movieId) {
        LOGGER.info("calling deleteMovie method from controller");
        return movieService.deleteMovie(movieId);
    }
}
