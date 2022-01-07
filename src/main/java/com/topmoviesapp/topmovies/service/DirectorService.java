package com.topmoviesapp.topmovies.service;

import com.topmoviesapp.topmovies.model.Director;
import com.topmoviesapp.topmovies.model.Genre;
import com.topmoviesapp.topmovies.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DirectorService {
    private DirectorRepository directorRepository;

    @Autowired
    public void setDirectorRepository(DirectorRepository directorRepository){
        this.directorRepository = directorRepository;
    }

    // This method checks if a director already exists. If it doesn't, create one.
    public Director createDirector(String name){
        Director director = directorRepository.findDirectorByDirectorNameIgnoreCase(name);
        if (director != null) {
            return director;
        } else {
            Director directorObject = new Director(name);
            return directorRepository.save(directorObject);
        }
    }
}
