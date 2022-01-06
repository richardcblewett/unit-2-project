package com.topmoviesapp.topmovies.repository;

import com.topmoviesapp.topmovies.model.Genre;
import com.topmoviesapp.topmovies.model.Director;
import com.topmoviesapp.topmovies.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    Movie findByUserProfileIdAndTitle(Long userProfileID, String name);
    Movie findByUserProfileIdAndId(Long userProfileID, Long movieID);
    List<Movie> findByUserProfileId(Long userProfileID);
    List<Movie> findByGenreAndUserProfileId(Genre genre, Long userProfileID);
    List<Movie> findByUserProfileIdAndDirector(Long userProfileID, Director director);
    boolean existsByRank(Long rank);
}
