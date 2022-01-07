package com.topmoviesapp.topmovies.imdbAPI;

import com.topmoviesapp.topmovies.exception.InformationMissingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/external-api")
public class MovieResourceController {

    @Autowired
    private RestTemplate restTemplate;

    private String apiKey = "k_d9vzzqby";
    //private String apiKey = "k_fnfzs9if";
    private String title = "matrix";

    private static String url = "https://imdb-api.com/en/API/Search/";
    private static String url2 = "https://imdb-api.com/en/API/Title/";

    @GetMapping("/movies")
    public ImdbMovie getMovies() {
        // https://imdb-api.com/en/API/Search/k_d9vzzqby/inception%202010
        SearchResult searchResult = restTemplate.getForObject(url + apiKey + "/" + title, SearchResult.class);
        if (searchResult == null) {throw new InformationMissingException("the movie " + title + " does not exist" );}
        String id = searchResult.results.get(0).id;
        ImdbMovie imdbMovie = restTemplate.getForObject(url2 + apiKey + "/" + id, ImdbMovie.class);
        if (imdbMovie != null) {
            return imdbMovie;
        } else {
            throw new InformationMissingException("movie ____ was not found in the database");
        }
    }
}
