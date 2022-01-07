package com.topmoviesapp.topmovies.repository;

import com.topmoviesapp.topmovies.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmailAddressIgnoreCase(String userEmailAddress);

    User findUserByEmailAddressIgnoreCase(String userEmailAddress);
}
