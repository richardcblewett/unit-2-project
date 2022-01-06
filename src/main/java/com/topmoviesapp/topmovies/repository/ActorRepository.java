package com.topmoviesapp.topmovies.repository;


import com.topmoviesapp.topmovies.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Long> {
    Actor findActorByName(String name);
}
