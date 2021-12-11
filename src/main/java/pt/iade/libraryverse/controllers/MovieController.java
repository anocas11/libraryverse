package pt.iade.libraryverse.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import pt.iade.libraryverse.models.CinematicUniverse;
import pt.iade.libraryverse.models.Movie;
import pt.iade.libraryverse.models.Response;
import pt.iade.libraryverse.models.repositories.CinematicUniverseRepository;
import pt.iade.libraryverse.models.repositories.MovieRepository;
import pt.iade.libraryverse.models.exceptions.NotFoundException;
import pt.iade.libraryverse.models.views.MovieActorsView;
import pt.iade.libraryverse.models.views.MovieCharactersView;
import pt.iade.libraryverse.models.views.MovieInfoView;


@RestController
@RequestMapping(path = "api/movies")
public class MovieController {
    private Logger logger = LoggerFactory.getLogger(MovieController.class);
    
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private CinematicUniverseRepository cuRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Movie> getMovies()
    {
        logger.info("Sending all movies");
        return movieRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Movie> getMovie(@PathVariable int id)
    {
        logger.info("Sending movie with id " + id);
        Optional<Movie> _movie = movieRepository.findById(id);
        if(_movie.isEmpty())
        {
            throw new NotFoundException("Movie", "id", "" + id);
        } 
        else
        {
            var resp = new Response<Movie>();
            resp.results = _movie.get();
            return resp;
        }
    }
    
    @GetMapping(path = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<List<Movie>> getMovieByName(@RequestParam String name)
    {
        logger.info("Sending movies with name " + name);
        Iterable<Movie> _movie = movieRepository.findAll();

        List<Movie> moviesList = new ArrayList<Movie>();

        _movie.forEach(movie -> {
            if(movie.getName().contains(name))
            {
                moviesList.add(movie);
            }
        });

        var resp = new Response<List<Movie>>();
        resp.results = moviesList;

        return resp;
    }
    
    @GetMapping(path = "/movie/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Iterable<MovieInfoView>> getMovieInfo(@PathVariable int id)
    {
        var resp = new Response<Iterable<MovieInfoView>>();
        resp.results = movieRepository.getMovieInfo(id);
        return resp;
    }

    @GetMapping(path = "/movie/{id}/characters", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Iterable<MovieCharactersView>> getMovieCharacters(@PathVariable int id)
    {
        var resp = new Response<Iterable<MovieCharactersView>>();
        resp.results = movieRepository.getMovieCharacters(id);
        return resp;
    }

    @GetMapping(path = "/movie/{id}/actors", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Iterable<MovieActorsView>> getMovieActors(@PathVariable int id)
    {
        var resp = new Response<Iterable<MovieActorsView>>();
        resp.results = movieRepository.getMovieActors(id);
        return resp;
    }
}
