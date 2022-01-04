package com.topmoviesapp.topmovies.model;

import javax.persistence.*;

@Entity
@Table
public class Genre {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long genreID;

    @Column
    private String genreName;

    public Genre() {
    }

    public Genre(Long genreID, String genreName) {
        this.genreID = genreID;
        this.genreName = genreName;
    }

    public Long getGenreID() {
        return genreID;
    }

    public void setGenreID(Long genreID) {
        this.genreID = genreID;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }
}
