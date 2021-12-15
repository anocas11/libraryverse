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

import pt.iade.libraryverse.models.Author;
import pt.iade.libraryverse.models.Response;
import pt.iade.libraryverse.models.views.AuthorBooksView;
import pt.iade.libraryverse.models.repositories.AuthorRepository;
import pt.iade.libraryverse.models.exceptions.NotFoundException;

@RestController
@RequestMapping(path = "api/authors")
public class AuthorController {
    private Logger logger = LoggerFactory.getLogger(AuthorController.class);

    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Author> getAuthors()
    {
        logger.info("Sending all authors");
        return authorRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Author getAuthor(@PathVariable int id)
    {
        logger.info("Sending author with id " + id);
        Optional<Author> _author = authorRepository.findById(id);
        if(_author.isEmpty())
        {
            throw new NotFoundException("Author", "id", "" + id);
        }
        else
        {
            return _author.get();
        }
    }

    @GetMapping(path = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<List<Author>> getAuthorByName(@RequestParam String name)
    {
        logger.info("Sending authors with name " + name);
        Iterable<Author> _author = authorRepository.findAll();
        
        List<Author> authorsList = new ArrayList<Author>();
        _author.forEach(author -> {
            if(author.getName().contains(name))
            {
                authorsList.add(author);
            }
        });
        
        var resp = new Response<List<Author>>();
        resp.results = authorsList;

        return resp;
    }

    @GetMapping(path = "/author/{id}/books", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Iterable<AuthorBooksView>> getAuthorBooks(@PathVariable int id)
    {
        var resp = new Response<Iterable<AuthorBooksView>>();
        resp.results = authorRepository.getAuthorBooks(id);
        return resp;
    }

}
