package com.topmoviesapp.topmovies.service;

import com.topmoviesapp.topmovies.exception.InformationExistsException;
import com.topmoviesapp.topmovies.exception.InformationMissingException;
import com.topmoviesapp.topmovies.imdbAPI.ImdbMovie;
import com.topmoviesapp.topmovies.imdbAPI.MovieResourceService;
import com.topmoviesapp.topmovies.model.Actor;
import com.topmoviesapp.topmovies.model.Genre;
import com.topmoviesapp.topmovies.model.Director;
import com.topmoviesapp.topmovies.model.Movie;
import com.topmoviesapp.topmovies.repository.ActorRepository;
import com.topmoviesapp.topmovies.repository.DirectorRepository;
import com.topmoviesapp.topmovies.repository.GenreRepository;
import com.topmoviesapp.topmovies.repository.MovieRepository;
import com.topmoviesapp.topmovies.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

@Service
public class MovieService {
    private MovieRepository movieRepository;
    private GenreRepository genreRepository;
    private ActorRepository actorRepository;
    private GenreService genreService;
    private DirectorRepository directorRepository;
    private DirectorService directorService;
    private MovieResourceService movieResourceService;
    private ActorService actorService;

    private static final Logger LOGGER = Logger.getLogger(MovieService.class.getName());

    @Autowired
    public void setMovieRepository(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Autowired
    public void setGenreService(GenreService genreService) {
        this.genreService = genreService;
    }

    @Autowired
    public void setDirectorService(DirectorService directorService) {
        this.directorService = directorService;
    }

    @Autowired
    public void setGenreRepository(GenreRepository genreRepository){this.genreRepository = genreRepository;}

    @Autowired
    public void setDirectorRepository(DirectorRepository directorRepository){
        this.directorRepository = directorRepository;
    }

    @Autowired
    public void setMovieResourceService(MovieResourceService movieResourceService){this.movieResourceService = movieResourceService;}

    @Autowired
    public void setActorService(ActorService actorService){
        this.actorService = actorService;
    }

    @Autowired
    public void setActorRepository(ActorRepository actorRepository){
        this.actorRepository = actorRepository;
    }
    //get all movies
    public List<Movie> getMovies() {
        LOGGER.info("calling getMovies method from service");
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Movie> movies = movieRepository.findByUserProfileId(userDetails.getUser().getUserProfile().getId());
        if (movies.isEmpty()) {
            throw new InformationMissingException("there are no movies associated with the " + userDetails.getUser().getEmailAddress() + " user account");
        } else {
            return movies;
        }
    }

    //get single movie
    public Movie getMovie(Long movieId) {
        LOGGER.info("calling getMovie method from service");
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Movie movie = movieRepository.findByUserProfileIdAndId(userDetails.getUser().getUserProfile().getId(), movieId);
        if (movie != null) {
            return movie;
        } else {
            throw new InformationMissingException("there is no movie with an id of " + movieId + " associated with the " + userDetails.getUser().getEmailAddress() + " user account");
        }
    }

    // This method accepts a movieObject
    // It searches if that movie is already in the database
    // If not, then add that movie into the database
    // If already exists in the database, then return Information already exists error
    public Movie createMovie(Movie movieObject) {
        LOGGER.info("calling createMovie method from service");
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Movie movie = movieRepository.findByUserProfileIdAndTitleIgnoreCase(userDetails.getUser().getUserProfile().getId(), movieObject.getTitle());
        if (movie != null) {
            throw new InformationExistsException("this movie is already associated with the " + userDetails.getUser().getEmailAddress() + " user account");
        } else {
            if(movieRepository.existsByRank(movieObject.getRank()) && movieObject.getRank() != null) {
                throw new InformationExistsException("A movie with the rank " + movieObject.getRank() + " already exists");
            }
            if(movieRepository.existsByTitle(movieObject.getTitle())){
                throw new InformationExistsException("A movie with the name " + movieObject.getTitle() + " already exists");
            }
            ImdbMovie imdbMovie = movieResourceService.getMovies(movieObject.getTitle());
            Set<Actor> actorSet = new HashSet<>();
            Set<Genre> genreSet = new HashSet<>();
            Set<Director> directorSet = new HashSet<>();
            Movie newMovie = new Movie(imdbMovie);
            newMovie.setUserProfile(userDetails.getUser().getUserProfile());
            newMovie.setRank(movieObject.getRank());
            imdbMovie.getActorList().forEach(actor -> actorSet.add(actorService.createActor(actor.getName())));
            imdbMovie.getGenreList().forEach(item -> genreSet.add(genreService.getGenre(item.getValue())));
            imdbMovie.getDirectorList().forEach(director -> directorSet.add(directorService.createDirector(director.getName())));
            newMovie.setActors(actorSet);
            newMovie.setGenre(genreSet);
            newMovie.setDirectors(directorSet);
            return movieRepository.save(newMovie);
        }
    }

    // This method accepts a movieId and a movie object.
    // It searches for a movie based on the movie ID
    // IF found, update that movie to match with the movieObject that was passed in
    // If not found, return a not found error
    public Movie updateMovie(Long movieId, Movie movieObject) {
        LOGGER.info("calling updateMovie method from service");
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Movie movie = movieRepository.findByUserProfileIdAndId(userDetails.getUser().getUserProfile().getId(), movieId);
        if (movie == null) {
            throw new InformationMissingException("there is no movie with an id of " + movieId + " associated with the " + userDetails.getUser().getEmailAddress() + " user account");
        } else {
            if(movieRepository.existsByRank(movieObject.getRank()) && movieObject.getRank() != null) {
                throw new InformationExistsException("A movie with the rank " + movieObject.getRank() + " already exists");
            }
            movie.setRank(movieObject.getRank());
            return movieRepository.save(movie);
        }
    }


    public Movie deleteMovie(Long movieId) {
        LOGGER.info("calling deleteMovie method from service");
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Movie movie = movieRepository.findByUserProfileIdAndId(userDetails.getUser().getUserProfile().getId(), movieId);
        if (movie == null) {
            throw new InformationMissingException("there is no movie with an id of " + movieId + " associated with the " + userDetails.getUser().getEmailAddress() + " user account");
        } else {
            movieRepository.deleteById(movieId);
            return movie;
        }
    }

    // This method searches for a movie given a genre ID and returns that movie
    public Set<Genre> getGenre(Long movieId) {
        LOGGER.info("calling getGenre method from service");
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Movie movie = movieRepository.findByUserProfileIdAndId(userDetails.getUser().getUserProfile().getId(), movieId);
        if (movie == null) {
            throw new InformationMissingException("there is no movie with an id of " + movieId + " associated with the " + userDetails.getUser().getEmailAddress() + " user account");
        } else {
            return movie.getGenre();
        }
    }

//    public List<Movie> getMovieListByGenre(Genre genreObject) {
//        LOGGER.info("calling MovieListByGenre method from service");
//        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        Genre genre = genreRepository.findGenreByName(genreObject.getName());
//        if (genre == null) {
//            throw new InformationMissingException("there are no movies associated with the " + genreObject.getName() + " genre and " + userDetails.getUser().getEmailAddress() + " user account");
//        } else {
//            return movieRepository.findByGenreAndUserProfileId(genre, userDetails.getUser().getUserProfile().getId());
//        }
//    }

    // This method searches for movie/movies given a director's name and return a List of movies
    public List<Movie> getMovieListByDirector(Director directorObject) {
        LOGGER.info("calling createMovie method from service");
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Director director = directorRepository.findDirectorByDirectorNameIgnoreCase(directorObject.getDirectorName());
        if(director == null){
            throw new InformationMissingException("director with name " + directorObject.getDirectorName() + " does not exist.");
        } else {
            return movieRepository.findByUserProfileIdAndDirectorsContainingIgnoreCase(userDetails.getUser().getUserProfile().getId(), director);
        }
    }

    public List<Movie> getMovieListByActor(Actor actorObject) {
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Actor actor = actorRepository.findActorByNameIgnoreCase(actorObject.getName());
        if(actor == null){
            throw new InformationMissingException("actir with name " + actorObject.getName() + " does not exist.");
        } else {
            return movieRepository.findByUserProfileIdAndActorsContainingIgnoreCase(userDetails.getUser().getUserProfile().getId(), actor);
        }
    }
}
