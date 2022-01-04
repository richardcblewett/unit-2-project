package com.topmoviesapp.topmovies.repository;

import com.topmoviesapp.topmovies.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    Movie findByUserIdAndName(Long userID, String name);
    Movie findByUserIdAndMovieId(Long userID, Long movieID);
    List<Movie> findByUserId();
    List<Movie> findByUserIdAndGenre(Long userID, Long genreID);
}
