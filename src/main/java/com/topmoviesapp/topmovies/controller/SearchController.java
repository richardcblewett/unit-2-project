package com.topmoviesapp.topmovies.controller;


import com.topmoviesapp.topmovies.model.Director;
import com.topmoviesapp.topmovies.model.Movie;
import com.topmoviesapp.topmovies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/search")
public class SearchController {

    private MovieService movieService;

    @Autowired
    public void setMovieService(MovieService movieService){
        this.movieService = movieService;
    }


    @GetMapping(path = "/director")
    public List<Movie> getMovieListByDirector(@RequestBody Director directorObject){
        return movieService.getMovieListByDirector(directorObject);
    }
}
