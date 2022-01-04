package com.topmoviesapp.topmovies.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InformationMissingException extends RuntimeException{
    public InformationMissingException(String message){
        super(message);
    }
}