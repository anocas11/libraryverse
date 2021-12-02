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

import pt.iade.libraryverse.models.Genre;
import pt.iade.libraryverse.models.repositories.GenreRepository;
import pt.iade.libraryverse.models.views.GenreView;
import pt.iade.libraryverse.models.exceptions.NotFoundException;

@RestController
@RequestMapping(path = "api/genres")
public class GenreController {
    private Logger logger = LoggerFactory.getLogger(GenreController.class);

    @Autowired
    private GenreRepository genreRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Genre> getGenres()
    {
        logger.info("Sending all genres");
        return genreRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Genre getGenre(@PathVariable int id)
    {
        logger.info("Sending genre with id " + id);
        Optional<Genre> _genre = genreRepository.findById(id);
        if(_genre.isEmpty())
        {
            throw new NotFoundException("Genre", "id", "" + id);
        } 
        else
        {
            return _genre.get();
        }
    }

    @GetMapping(path = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Genre> getGenreByName(@RequestParam String name)
    {
        logger.info("Sending genres with name " + name);
        Iterable<Genre> _genre = genreRepository.findAll();

        List<Genre> genresList = new ArrayList<Genre>();

        _genre.forEach(genre -> {
            if(genre.getName().contains(name))
            {
                genresList.add(genre);
            }
        });

        return genresList;
    }

    @GetMapping(path = "/movies/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<GenreView> getGenreByMovie(@PathVariable int id)
    {
        logger.info(id + " -> Genres: ");
        return genreRepository.findGenreByMovie(id);
    }

    @GetMapping(path = "/books/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<GenreView> getGenreByBook(@PathVariable int id)
    {
        logger.info(id + " -> Genres: ");
        return genreRepository.findGenreByBook(id);
    }

}
