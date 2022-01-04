package com.topmoviesapp.topmovies.model;

import javax.persistence.*;

@Entity
@Table(name = "directors")
public class Director {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String directorName;

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
        this.id = id;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }
}
