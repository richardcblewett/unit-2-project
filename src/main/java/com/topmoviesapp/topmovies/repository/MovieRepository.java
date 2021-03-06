package com.topmoviesapp.topmovies.repository;

import com.topmoviesapp.topmovies.model.Actor;
import com.topmoviesapp.topmovies.model.Genre;
import com.topmoviesapp.topmovies.model.Director;
import com.topmoviesapp.topmovies.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    Movie findTopByUserProfileIdAndTitleContainsIgnoreCase(Long userProfileID, String name);
    Movie findByUserProfileIdAndId(Long userProfileID, Long movieID);
    List<Movie> findByUserProfileId(Long userProfileID);
    List<Movie> findByUserProfileIdAndGenresContainingIgnoreCase(Long userProfileID,Genre genre);
    List<Movie> findByUserProfileIdAndDirectorsContainingIgnoreCase(Long userProfileID, Director director);
    List<Movie> findByUserProfileIdAndActorsContainingIgnoreCase(Long userProfileID, Actor actor);
    List<Movie> findByUserProfileIdAndImdbRatingGreaterThanEqual(Long userProfileID, double rating);
    List<Movie> findByUserProfileIdAndRankIsLessThanEqualOrderByRank(Long userProfileID, Long rankId);
    boolean existsByUserProfileIdAndRank(Long userProfileID, Long rank);
    boolean existsByTitleIgnoreCase(String movieName);
}
