package com.topmoviesapp.topmovies.imdbAPI;

import org.w3c.dom.Text;

import java.util.List;

public class ImdbMovie {
    private String title;
    private String directors;
    private String genres;
    private Long year;
    private String plot;
    private Long runtimeMins;
    private List<ImdbActor> actorList;
    private Double imDbRating;
    private String contentRating;


    public ImdbMovie() {
    }

    public ImdbMovie(String title, String directors, String genres, Long year, String plot, Long runtimeMins, List<ImdbActor> actorList, Double imDbRating, String contentRating) {
        this.title = title;
        this.directors = directors;
        this.genres = genres;
        this.year = year;
        this.plot = plot;
        this.runtimeMins = runtimeMins;
        this.actorList = actorList;
        this.imDbRating = imDbRating;
        this.contentRating = contentRating;
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

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public Long getRuntimeMins() {
        return runtimeMins;
    }

    public void setRuntimeMins(Long runtimeMins) {
        this.runtimeMins = runtimeMins;
    }

    public List<ImdbActor> getActorList() {
        return actorList;
    }

    public void setActorList(List<ImdbActor> actorList) {
        this.actorList = actorList;
    }

    public Double getImDbRating() {
        return imDbRating;
    }

    public void setImDbRating(Double imDbRating) {
        this.imDbRating = imDbRating;
    }

    public String getContentRating() {
        return contentRating;
    }

    public void setContentRating(String contentRating) {
        this.contentRating = contentRating;
    }
}
