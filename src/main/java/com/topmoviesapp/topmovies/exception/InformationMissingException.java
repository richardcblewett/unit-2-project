package com.topmoviesapp.topmovies.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class InformationMissingException extends RuntimeException{
    public InformationMissingException(String message){
        super(message);
    }
}