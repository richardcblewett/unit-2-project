package com.topmoviesapp.topmovies.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.topmoviesapp.topmovies.imdbAPI.ImdbMovie;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column(unique = true)
    private Long rank;

    @Column
    private Long releaseYear;

    @Column(columnDefinition = "text")
    private String description;

    @Column
    private Integer length;

    @Column
    private Double imdbRating;

    @Column
    private String contentRating;

    //LINKS TO OTHER TABLES
    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable
    private Set<Director> directors;

    @ManyToOne
    @JoinColumn(name="userprofile_id")
    @JsonIgnore
    private UserProfile userProfile;


    //https://stackoverflow.com/questions/42394095/many-to-many-relationship-between-two-entities-in-spring-boot/42396995
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable
    private Set<Actor> actors;

    public Movie(Long id, String title, Long rank, Long releaseYear, String description, Integer length,
                 Double imdbRating, String contentRating, Genre genre, UserProfile userProfile) {
        this.id = id;
        this.title = title;
        this.rank = rank;
        this.releaseYear = releaseYear;
        this.description = description;
        this.length = length;
        this.imdbRating = imdbRating;
        this.contentRating = contentRating;
        this.genre = genre;
        this.userProfile = userProfile;
    }

    public Movie (ImdbMovie imdbMovie){
        this.title = imdbMovie.getTitle();
        this.releaseYear = imdbMovie.getYear();
        this.description = imdbMovie.getPlot();
        this.length = imdbMovie.getRuntimeMins();
        this.imdbRating = imdbMovie.getImDbRating();
        this.contentRating = imdbMovie.getContentRating();
    }

    public Movie() {
    }

    public Long getMovieID() {
        return id;
    }

    public void setMovieID(Long movieID) {
        this.id = movieID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getRank() {
        return rank;
    }

    public void setRank(Long rank) {
        this.rank = rank;
    }

    public Long getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Long releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Double getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(Double imdbRating) {
        this.imdbRating = imdbRating;
    }

    public String getContentRating() {
        return contentRating;
    }

    public void setContentRating(String contentRating) {
        this.contentRating = contentRating;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }

    public Set<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(Set<Director> directors) {
        this.directors = directors;
    }
}
