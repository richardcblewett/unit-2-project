package com.topmoviesapp.topmovies.controller;

import com.topmoviesapp.topmovies.model.Movie;
import com.topmoviesapp.topmovies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api")
public class MovieController {
    private MovieService movieService;


    @Autowired
    public void setMovieService(MovieService movieService){
        this.movieService = movieService;
    }

    @GetMapping("/topmovies")
    public Movie createMovie(@RequestBody Movie movie){
        return movieService.createMovie(movie);
    }
}
