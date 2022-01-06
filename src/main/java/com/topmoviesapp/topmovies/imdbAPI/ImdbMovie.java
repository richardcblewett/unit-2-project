package com.topmoviesapp.topmovies.imdbAPI;

import java.util.List;

public class ImdbMovie {
    private String title;
    private String directors;
    private String genres;
    private Long year;

    public ImdbMovie() {
    }

    public ImdbMovie(String title, String directors, String genres, Long year) {
        this.title = title;
        this.directors = directors;
        this.genres = genres;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirectors() {
        return directors;
    }

    public void setDirectors(String directors) {
        this.directors = directors;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }
}
