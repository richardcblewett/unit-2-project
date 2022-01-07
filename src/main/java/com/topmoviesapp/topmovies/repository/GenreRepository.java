package com.topmoviesapp.topmovies.repository;

import com.topmoviesapp.topmovies.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre,Long> {
    boolean existsByNameIgnoreCase(String name);
    Genre findGenreByNameIgnoreCase(String name);
}
