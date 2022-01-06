package com.topmoviesapp.topmovies.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @Column
    private String description;

    @Column
    private Integer length;

    @Column
    private Double imdbRating;

    @Column
    private String contentRating;

    @OneToMany(mappedBy = "movies")
    private Set<Cast> actors;

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

    public Movie(Long id, String title, Long rank, Long releaseYear, String description, Integer length,
                 Double imdbRating, String contentRating, Genre genre, Director director, UserProfile userProfile) {
        this.id = id;
        this.title = title;
        this.rank = rank;
        this.releaseYear = releaseYear;
        this.description = description;
        this.length = length;
        this.imdbRating = imdbRating;
        this.contentRating = contentRating;
        this.genre = genre;
        this.director = director;
        this.userProfile = userProfile;
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

}
