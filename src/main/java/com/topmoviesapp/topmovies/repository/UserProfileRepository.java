package com.topmoviesapp.topmovies.repository;

import com.topmoviesapp.topmovies.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile,Long> {

}
