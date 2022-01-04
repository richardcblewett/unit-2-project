package com.topmoviesapp.topmovies.service;

import com.topmoviesapp.topmovies.model.Director;
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
    public Director createDirector(Director directorObject){
        Director director = directorRepository.findDirectorByDirectorName(directorObject.getDirectorName());
        if(director != null) {
            return director;
        } else {
            return directorRepository.save(directorObject);
        }
    }
}
