package com.topmoviesapp.topmovies.model;

import com.fasterxml.jackson.annotation.JsonBackReference;


import javax.persistence.*;

import java.util.Set;

@Entity
@Table(name = "directors")
public class Director {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String directorName;

    @ManyToMany(mappedBy = "directors")
    private Set<Movie> movies;

    public Director() {
    }

    public Director(String directorName) {
        this.directorName = directorName;
    }

    public Long getDirectorID() {
        return id;
    }

    public void setDirectorID(Long directorID) {
        this.id = directorID;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    @JsonBackReference
    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }
}
