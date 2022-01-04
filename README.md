# Top Movies Application

### Project Description:
This is an application where users can record and rank their favorite movies.
The movies will include the title, the director, the release date, and the genre.

## ERD 
{inset photo}

## Endpoints:  

| Request Type | URL| Request Body                                              | Request Header               |         |   
|---|---|-----------------------------------------------------------|------------------------------|---------|    
| POST | /auth/users/register | emailAddress <br> password                                | Authorization: none          | PUBLIC  |
| POST | /auth/users/login | email <br> password                                       | Authorization: none          | PUBLIC  |
| GET | /api/movies |                                                           | Authorization: Bearer token  | PRIVATE |
| POST | /api/movies | title <br> rank <br> releaseYear <br> genre <br> director | Authorization: Bearer token  | PRIVATE |
| GET | /api/movies/{movie-id} | | Authorization: Bearer token  | PRIVATE |
| PUT | /api/movies/{movie-id} | | Authorization: Bearer token  | PRIVATE |
| DELETE | /api/movies/{movie-id} | | Authorization: Bearer token  | PRIVATE |
| GET | /api/movies/{movie-id}/director | | Authorization: Bearer token  | PRIVATE |
| GET | /api/movies/{movie-id}/genres | | Authorization: Bearer token  | PRIVATE |



## User Stories:
### MVP
As a user, I want to be able to add movies to my list of movies.
As a user, I want to be able to rank my top movies.
As a user, I want to be able to find out who directed one of my movies.
As a user, I want to be able to find out what genre my movie is in.


### SILVER
As a user, I want to be able to list my movies by genre.
As a user, I want to be able to list my movies by director.
As a user, I want to be able to list what years my movies were released.
As a user, I want to be able to find out which movie is my nth rank movie.


### GOLD
As a user, I want to be able to find my top movies based on the actor.


### PLATINUM
Based on the user’s input of a movie name, we should be able to pull details from an API so the user does not have to fill them all out.
