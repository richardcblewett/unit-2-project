package com.topmoviesapp.topmovies.model;

import org.hibernate.mapping.ToOne;

import javax.persistence.*;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieID;

    @Column
    private String title;

    @Column
    private Long rank;

    @Column
    private Long releaseYear;

    //LINKS TO OTHER TABLES
    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @ManyToOne
    @JoinColumn(name = "director_id")
    private Director director;

    public Movie(Long movieID, String title, Long rank, Long releaseYear, Genre genre, Director director) {
        this.movieID = movieID;
        this.title = title;
        this.rank = rank;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.director = director;
    }

    public Movie() {
    }

    public Long getMovieID() {
        return movieID;
    }

    public void setMovieID(Long movieID) {
        this.movieID = movieID;
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

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    //TODO later with API
    //@Column
    //private List<Actor> castList;

    //TODO later with API
    //@Column
    //private Long duration;

}
