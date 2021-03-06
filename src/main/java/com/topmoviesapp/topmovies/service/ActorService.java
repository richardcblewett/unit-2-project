package com.topmoviesapp.topmovies.service;

import com.topmoviesapp.topmovies.model.Actor;
import com.topmoviesapp.topmovies.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class ActorService {
    private ActorRepository actorRepository;
    private static final Logger LOGGER = Logger.getLogger(MovieService.class.getName());


    @Autowired
    public void setActorRepository(ActorRepository actorRepository){
        this.actorRepository = actorRepository;
    }

    public Actor createActor(String name){
        Actor actor = actorRepository.findActorByNameIgnoreCase(name);
        if(actor != null){
            return actor;
        } else{
            Actor actorObject = new Actor();
            actorObject.setName(name);
            return actorRepository.save(actorObject);
        }
    }
}
