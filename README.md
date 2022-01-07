# Top Movies App

### Project Description:
This is an application where users can record and rank their favorite movies.   
The movies will include title, director, genre, runtime, and list of actors.   

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
The standard packages were created first (controller, model, repository, service), but with the security package in mind.   
We added the security and exception packages later.   
Once we arrived at the MVP, we decided to do a bit of research on our platinum goal.     
We decided there was enough time to hit our platinum goal and then go back and make sure the silver and gold goals were covered because that would require a lot less code refactoring.  

Everything involving the api we chose to work with is inside its own package. This helps us separate the interactive par t of the application from external sources of information. 

The initial coding (almost "boilerplate" but not quite) was split evenly between both of us, and was coded in parallel.   
When we got to trickier bits of code, we took a "pair programming" approach with one person driving and the other person navigating.    

When researching the best way to fix an issue, we make sure we were on the same branch and referenced specific lines of code in individual files.

When debugging issues, it was easiest to share the screen with another person. 

## Unsolved Problems / Future Plans
Currently, our database has the individual user's rank of a movie in the movie record itself. This means the same movie could be stored in the database multiple times, which is not ideal. (But necessary if more than one user likes the same movie.) 

The user profile could be used more extensively, but we did not think expanding the profile was the most important use of our time.

There is a lot more information returned by the api, so future expansion opportunities are available and can be added with minimal fuss. 

The information returned to the user may contain more information than a user wants. We felt our time was better spent working with the backend rather than fine-tuning the interface. 

## Hurdles Overcome
- Autowire is necessary, or else objects return null point exception. (Discovered when debugging code.)
- Figuring out how to implement a many-to-many relationship in Spring. Credit to <a href="doc:introduction" target="https://stackoverflow.com/questions/42394095/many-to-many-relationship-between-two-entities-in-spring-boot/42396995">Stackoverflow</a>
- Convert 

## Documentation

### ERD

![Entity Relationship Diagram](img/erd.png)

### Endpoints:  

| Request Type | URL                       | Request Body               | Request Header              | Action                                                          | Access  |   
|--------------|---------------------------|----------------------------|-----------------------------|-----------------------------------------------------------------|---------|
| POST         | /auth/users/register      | emailAddress <br> password | Authorization: none         | registers a user                                                | PUBLIC  |
| POST         | /auth/users/login         | email <br> password        | Authorization: none         | allows a user to login                                          | PUBLIC  |
| GET          | /api/movies               |                            | Authorization: Bearer token | returns a list of all movies                                    | PRIVATE |
| POST         | /api/movies               | title <br> rank            | Authorization: Bearer token | adds a movie to the database with information from imdb-api.com | PRIVATE |
| GET          | /api/movies/{movie-id}    |                            | Authorization: Bearer token | returns a single movie                                          | PRIVATE |
| PUT          | /api/movies/{movie-id}    |                            | Authorization: Bearer token | updates an existing movie                                       | PRIVATE |
| DELETE       | /api/movies/{movie-id}    |                            | Authorization: Bearer token | removes a movie from the database                               | PRIVATE |
| GET          | /api/search/actor         | name                       | Authorization: Bearer token | returns a list of movies in which the actor appears             | PRIVATE |
| GET          | /api/search/director      | name                       | Authorization: Bearer token | returns a list of movies from the specified director            | PRIVATE | 
| GET          | /api/search/genre         | name                       | Authorization: Bearer token | returns a list of movies in the specified genre                 | PRIVATE | 
| GET          | /api/search/rating        | name                       | Authorization: Bearer token | returns a list of movies with the specified rating              | PRIVATE |
| GET          | /api/search/rank/{rankId} | name                       | Authorization: Bearer token | returns a list of movies ranked at or higher than the rank id   | PRIVATE |


## User Stories:
### MVP
-[x] As a user, I want to be able to add movies to my list of movies.
-[x] As a user, I want to be able to rank my top movies.
-[x] As a user, I want to be able to find out who directed one of my movies.
-[x] As a user, I want to be able to find out what genre my movie is in.


### SILVER
-[x] As a user, I want to be able to find my movies by genre.
-[x] As a user, I want to be able to find my movies by director.
-[x] As a user, I want to be able to list my movies in ranking order.


### GOLD
-[x] As a user, I want to be able to find my top movies based on the actor.


### PLATINUM
-[x] Based on the user’s input of a movie name, we should be able to pull details from an API so the user does not have to fill out the movie details.



## Installation Instructions
1. Fork and Clone this repository.
2. Make sure PostGreSql is installed on your computer
   1. If PostGreSQL is not installed, install the program from : https://www.postgresql.org/download/
3. Make sure pgAdmin is installed on your computer
   1. If pgAdmin is not installed, install the program from: https://www.pgadmin.org/download/
4. Open up pgAdmin and create a database called "topmoviesapp"
5. Make sure the username and password used in creation of the "topmoviesapp" database is in the repository file: "src/main/resources/application-dev.properties"
6. Open an IDE (such as IntelliJ IDEA or VSCode) and run the project
7. Register your user at http://localhost:9092/auth/users/register and use the documented endpoints to get started!
