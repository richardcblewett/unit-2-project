package com.topmoviesapp.topmovies.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.topmoviesapp.topmovies.service.DirectorService;
import org.hibernate.mapping.ToOne;

import javax.persistence.*;

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

    //LINKS TO OTHER TABLES
    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @ManyToOne
    @JoinColumn(name = "director_id")
    private Director director;

    @ManyToOne
    @JoinColumn(name="userprofile_id")
    @JsonIgnore
    private UserProfile userProfile;

    public Movie(Long id, String title, Long rank, Long releaseYear, Genre genre,  Director director) {
        this.id = id;
        this.title = title;
        this.rank = rank;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.director = director;
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

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }


    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    //TODO later with API
    //@Column
    //private List<Actor> castList;

    //TODO later with API
    //@Column
    //private Long duration;

}
