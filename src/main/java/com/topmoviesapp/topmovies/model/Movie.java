package com.topmoviesapp.topmovies.model;

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
    @Column
    private Genre genre;

    @ManyToOne
    @JoinColumn(name = "director_id")
    @Column
    //when a user requests a movie, we want to return the director. so no jsonignore
    private Director director;

    //TODO later with API
    //@Column
    //private List<Actor> castList;

    //TODO later with API
    //@Column
    //private Long duration;

}
