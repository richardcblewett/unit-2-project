package com.topmoviesapp.topmovies.repository;

import com.topmoviesapp.topmovies.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GenreRepository extends JpaRepository<Genre,Long> {
    Genre findByUserIDAndName(Long userID, String Name);
    Genre findByUserIDAndGenreID(Long userID, Long genreID);
    List<Genre> findByUserID(Long userID);
}
