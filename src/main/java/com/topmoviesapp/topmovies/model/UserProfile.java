package com.topmoviesapp.topmovies.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.catalina.User;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;

@Entity
@Table(name = "profiles")
public class UserProfile {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @OneToOne(mappedBy = "userProfile")
    private User user;

    @OneToMany(mappedBy = "userProfile")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Movie> movieList;

    public UserProfile(){

    }
}
