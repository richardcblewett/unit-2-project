package com.topmoviesapp.topmovies.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "directors")
public class Director {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String directorName;

    @OneToMany(mappedBy = "director", orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Movie> movieList;

    public Director() {
    }

    public Director(Long directorID, String directorName) {
        this.id = directorID;
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
}
