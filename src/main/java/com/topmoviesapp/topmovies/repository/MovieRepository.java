package com.topmoviesapp.topmovies.repository;

import com.topmoviesapp.topmovies.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    Movie findByUserIDAndName(Long userID, String name);
    Movie findByUserIDAndMovieID(Long userID, Long movieID);
    List<Movie> findByUserID();
    List<Movie> findByUserIDAndGenre(Long userID, Long genreID);
}
