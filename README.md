# Top Movies App

### Project Description:
This is an application where users can record and rank their favorite movies.   
The movies will include the title, the director, the release date, and the genre.   

## Machineries Used
- LucidChart (creating ERD)
- GoogleDocs (initial design collaboration)
- IntelliJ IDEA (IDE)
- SpringBoot (framework)
- Maven (dependency management)
- postgresql (database)
- pgAdmin (managing the database)
- Postman (endpoint testing)

## Design Approach

## Unsolved Problems

## Hurdles Overcome
- Autowire is necessary, or else objects return null point exception. (Discovered when debugging code.)
- Figuring out how to implement a many-to-many relationship in Spring. Credit to <a href="doc:introduction" target="https://stackoverflow.com/questions/42394095/many-to-many-relationship-between-two-entities-in-spring-boot/42396995">Stackoverflow</a>
- Convert 
## Planning Documentation

### GoogleDoc(?)

### ERD

![](img/erd.png)

## Endpoints:  

| Request Type | URL                            | Request Body                                              | Request Header              | Action                                               | Access   |   
|---|--------------------------------|-----------------------------------------------------------|------------------------------|------------------------------------------------------|----------|    
| POST | /auth/users/register           | emailAddress <br> password                                | Authorization: none | registers a user                                     | PUBLIC   |
| POST | /auth/users/login              | email <br> password                                       | Authorization: none | allows a user to login                               | PUBLIC   |
| GET | /api/movies                    |                                                           | Authorization: Bearer token  | returns a list of all movies                         | PRIVATE  |
| POST | /api/movies                    | title <br> rank <br> releaseYear <br> genre <br> director | Authorization: Bearer token  | adds a movie to the database                         | PRIVATE  |
| GET | /api/movies/{movie-id}         | | Authorization: Bearer token  | returns a single movie                               | PRIVATE  |
| PUT | /api/movies/{movie-id}         | | Authorization: Bearer token  | updates an existing movie                            | PRIVATE  |
| DELETE | /api/movies/{movie-id}         | | Authorization: Bearer token  | removes a movie from the database                    | PRIVATE  |
| GET | /api/movies/{movie-id}/director | | Authorization: Bearer token  | returns the specified movie's director               | PRIVATE  |
| GET | /api/movies/{movie-id}/genres  | | Authorization: Bearer token  | returns the specified movie's genre                  | PRIVATE  |
| GET | /api/search/director           | name | Authorization: Bearer token | returns a list of movies from the specified director | PRIVATE  | 
| GET | /api/search/genre | name | Authorization: Bearer token | returns a list of movies in the specified genre      | PRIVATE  | 


## User Stories:
### MVP
- As a user, I want to be able to add movies to my list of movies.
- As a user, I want to be able to rank my top movies.
- As a user, I want to be able to find out who directed one of my movies.
- As a user, I want to be able to find out what genre my movie is in.


### SILVER
- As a user, I want to be able to list my movies by genre.
- As a user, I want to be able to list my movies by director.
- As a user, I want to be able to find out which movie is my nth rank movie.


### GOLD
- As a user, I want to be able to find my top movies based on the actor.


### PLATINUM
- Based on the user’s input of a movie name, we should be able to pull details from an API so the user does not have to fill out the movie details.



## Installation Instructions
1. Fork and Clone this repository.
2. Make sure PostGreSql is installed on your computer
   1. If PostGreSQL is not installed, install the program from : https://www.postgresql.org/download/
3. Make sure pgAdmin is installed on your computer
   1. If pgAdmin is not installed, install the program from: https://www.pgadmin.org/download/
4. Open up pgAdmin and create a database called "topmoviesapp"
5. Make sure the username and password used in creation of the "topmoviesapp" database is in the repository file: "src/main/resources/application-dev.properties"
