package com.topmoviesapp.topmovies.service;

import com.topmoviesapp.topmovies.model.Genre;
import com.topmoviesapp.topmovies.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class GenreService {
    private GenreRepository genreRepository;
    private static final Logger LOGGER = Logger.getLogger(MovieService.class.getName());

    @Autowired
    public void setGenreRepository(GenreRepository genreRepository){this.genreRepository = genreRepository;}

    //checks if a specific genre exists. if one does not, one is created.
    public Genre getGenre(String name){
        LOGGER.info("calling getGenre method from service");
        if (!genreRepository.existsByName(name)) {
            Genre genreObject = new Genre();
            genreObject.setName(name);
            return genreRepository.save(genreObject);
        } else {
            return genreRepository.findGenreByName(name);
        }
    }
}
