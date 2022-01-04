package com.topmoviesapp.topmovies.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    Movie findByUserIDAndName(Long userID, String name);
    Movie findByUserIDAndMovieID(Long userID, Long movieID);
    List<Movie> findByUserID();
    List<Movie> findByUserIDAndGenre(Long userID, Long genreID);
}
