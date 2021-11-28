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

import pt.iade.libraryverse.models.Movie;
import pt.iade.libraryverse.models.Response;
import pt.iade.libraryverse.models.repositories.MovieRepository;
import pt.iade.libraryverse.models.exceptions.NotFoundException;

@RestController
@RequestMapping(path = "api/movies")
public class MovieController {
    private Logger logger = LoggerFactory.getLogger(MovieController.class);
    
    @Autowired
    private MovieRepository movieRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Movie> getMovies()
    {
        logger.info("Sending all movies");
        return movieRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Movie getMovie(@PathVariable int id)
    {
        logger.info("Sending movie with id " + id);
        Optional<Movie> _movie = movieRepository.findById(id);
        if(_movie.isEmpty())
        {
            throw new NotFoundException("Movie", "id", "" + id);
        } 
        else
        {
            return _movie.get();
        }
    }
    
    @GetMapping(path = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Movie> getMovieByName(@RequestParam String name)
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

        var resp = new Response<Movie>();
        resp.results = moviesList;

        return resp;
    }
}
