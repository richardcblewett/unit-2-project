package com.topmoviesapp.topmovies.repository;

import org.apache.tomcat.jni.Directory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DirectorRepository extends JpaRepository<Director, Long> {
    Director findByUserIDAndName(Long userID, String Name);
    Director findByUserIDAndDirectorID(Long userID, Long directorID);
    List<Director> findByUserID(Long userID);
}
