package com.topmoviesapp.topmovies.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.topmoviesapp.topmovies.model.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/external-api")
public class MovieResourceController {


    @Autowired
    private RestTemplate restTemplate;

    private String apiKey = "k_d9vzzqby";

    private static String url = "https://imdb-api.com/en/API/Search/";

    @GetMapping("/movies")
    public SearchResult getMovies(){
        // https://imdb-api.com/en/API/Search/k_d9vzzqby/inception%202010
       SearchResult searchResult = restTemplate.getForObject(url + apiKey + "/" + "inception 2010", SearchResult.class);
       return searchResult;
    }


}
