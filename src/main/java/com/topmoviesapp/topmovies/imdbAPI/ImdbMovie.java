package com.topmoviesapp.topmovies.imdbAPI;


import java.util.Set;

public class ImdbMovie {
    private String title;
    private String genres;
    private Long year;
    private String plot;
    private Integer runtimeMins;
    private Set<ImdbActor> actorList;
    private Set<ImdbDirector> directorList;
    private Double imDbRating;
    private String contentRating;
    private Set<ImdbGenre> genreList;


    public ImdbMovie() {
    }

    public ImdbMovie(String title, String genres, Long year, String plot, Integer runtimeMins, Set<ImdbActor> actorList, Double imDbRating, String contentRating) {
        this.title = title;
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

    public Integer getRuntimeMins() {
        return runtimeMins;
    }

    public void setRuntimeMins(Integer runtimeMins) {
        this.runtimeMins = runtimeMins;
    }

    public Set<ImdbActor> getActorList() {
        return actorList;
    }

    public void setActorList(Set<ImdbActor> actorList) {
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

    public Set<ImdbGenre> getGenreList() {
        return genreList;
    }

    public void setGenreList(Set<ImdbGenre> genreList) {
        this.genreList = genreList;
    }

    public Set<ImdbDirector> getDirectorList() {
        return directorList;
    }

    public void setDirectorList(Set<ImdbDirector> directorList) {
        this.directorList = directorList;
    }
}
