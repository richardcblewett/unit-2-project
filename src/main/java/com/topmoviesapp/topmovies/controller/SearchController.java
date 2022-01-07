package com.topmoviesapp.topmovies.controller;


import com.topmoviesapp.topmovies.model.Actor;
import com.topmoviesapp.topmovies.model.Genre;
import com.topmoviesapp.topmovies.model.Director;
import com.topmoviesapp.topmovies.model.Movie;
import com.topmoviesapp.topmovies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(path = "/api/search")
public class SearchController {

    private static final Logger LOGGER = Logger.getLogger(SearchController.class.getName());
    private MovieService movieService;

    @Autowired
    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }

    //http://localhost:9092/api/search/genre
    @GetMapping("/genre")
    public List<Movie> getMovieListByGenre(@RequestBody Genre genre) {
        LOGGER.info("calling getMovieListByGenre method from controller");
        return movieService.getMovieListByGenre(genre);
    }

    //http://localhost:9092/api/search/director
    @GetMapping(path = "/director")
    public List<Movie> getMovieListByDirector(@RequestBody Director directorObject){
        LOGGER.info("calling getMovieListByGenre method from controller");
        return movieService.getMovieListByDirector(directorObject);
    }

    //http://localhost:9092/api/search/actor
    @GetMapping(path = "/actor")
    public List<Movie> getMovieListByActor(@RequestBody Actor actorObject){
        return movieService.getMovieListByActor(actorObject);
    }
}
