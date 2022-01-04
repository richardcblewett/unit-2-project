package com.topmoviesapp.topmovies.repository;

import com.topmoviesapp.topmovies.model.Director;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DirectorRepository extends JpaRepository<Director,Long> {

}
