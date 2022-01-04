package pt.iade.libraryverse.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import pt.iade.libraryverse.models.Response;
import pt.iade.libraryverse.models.User;
import pt.iade.libraryverse.models.repositories.UserRepository;
import pt.iade.libraryverse.models.views.UserBooksView;
import pt.iade.libraryverse.models.exceptions.NotFoundException;
import pt.iade.libraryverse.models.views.UserMoviesView;

@RestController
@RequestMapping(path = "api/users")
public class UserController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;

    //FALHA DE SEGURANÇA!!
    /*@GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<User> getUsers()
    {
        logger.info("Sending all users");
        return userRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUsers(@PathVariable int id)
    {
        logger.info("Sending user with id " + id);
        Optional<User> _user = userRepository.findById(id);
        if(_user.isEmpty())
        {
            throw new NotFoundException("Users", "id", "" + id);
        }
        else
        {
            return _user.get();
        }
    }*/

    @PostMapping(path="/signup", produces = MediaType.APPLICATION_JSON_VALUE)
    public User saveUser(@RequestBody User user)
    {
        Iterable<User> _user = userRepository.findAll();

        _user.forEach(userToCompare ->
        {
        
            if(userToCompare.getUsername().compareTo(user.getUsername()) == 0)
            {
                throw new ResponseStatusException(HttpStatus.FOUND, "username already exists");
            }

            if(userToCompare.getEmail().compareTo(user.getEmail()) == 0)
            {
                throw new ResponseStatusException(HttpStatus.FOUND, "email already exists");
            }
        });

        User savedUser = userRepository.save(user);
        logger.info("Saving user with id " + savedUser.getId());
        savedUser.setPassword(null);
        return savedUser;
    }

    @PostMapping(path="/signin", produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUser(@RequestBody User user)
    {
        Optional<User> _user = userRepository.findByUsername(user.getUsername());

        if(_user.isEmpty()){
            throw new ResponseStatusException(HttpStatus.FOUND, "could not login");
        }

        User userToVerify = _user.get();
        if(userToVerify.getPassword().equals(user.getPassword())){
            userToVerify.setPassword(null);
            return userToVerify;
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "could not login");
    }

    @PostMapping(path="/{id}/userdata", produces = MediaType.APPLICATION_JSON_VALUE)
    public User saveUserData(@RequestBody User user, @PathVariable int id)
    {
        Optional<User> _user = userRepository.findById(id);

        if(_user.isEmpty()){
            throw new ResponseStatusException(HttpStatus.FOUND, "could not find");
        }

        User userToUpdate = _user.get();
        if(!userToUpdate.getName().equals(user.getName()) || !userToUpdate.getEmail().equals(user.getEmail()) || !userToUpdate.getPassword().equals(user.getPassword()))
        {
            userToUpdate.setName(user.getName());
            userToUpdate.setEmail(user.getEmail());
            userToUpdate.setPassword(user.getPassword());
            userRepository.save(userToUpdate);
        }

        User userToVerify = _user.get();

        userToVerify.setPassword(null);
        return userToVerify;
    }

    @GetMapping(path = "/user/{id}/books", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Iterable<UserBooksView>> getUserBooks(@PathVariable int id)
    {
        var resp = new Response<Iterable<UserBooksView>>();
        resp.results = userRepository.getUserBooks(id);
        return resp;
    }
     
    @GetMapping(path = "/user/{id}/movies", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Iterable<UserMoviesView>> getUserMovies(@PathVariable int id)
    {
        var resp = new Response<Iterable<UserMoviesView>>();
        resp.results = userRepository.getUserMovies(id);
        return resp;
    }

    @GetMapping(path = "/user/{id}/favoritebooks", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Iterable<UserBooksView>> getUserFavoriteBooks(@PathVariable int id)
    {
        var resp = new Response<Iterable<UserBooksView>>();
        resp.results = userRepository.getUserFavoriteBooks(id);
        return resp;
    }

    @GetMapping(path = "/user/{id}/lastbooks", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Iterable<UserBooksView>> getUserLastBooks(@PathVariable int id)
    {
        var resp = new Response<Iterable<UserBooksView>>();
        resp.results = userRepository.getUserLastBooks(id);
        return resp;
    }

    @GetMapping(path = "/user/{id}/favoritemovies", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Iterable<UserMoviesView>> getUserFavoriteMovies(@PathVariable int id)
    {
        var resp = new Response<Iterable<UserMoviesView>>();
        resp.results = userRepository.getUserFavoriteMovies(id);
        return resp;
    }

    @GetMapping(path = "/user/{id}/lastmovies", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Iterable<UserMoviesView>> getUserLastMovies(@PathVariable int id)
    {
        var resp = new Response<Iterable<UserMoviesView>>();
        resp.results = userRepository.getUserLastMovies(id);
        return resp;
    }
}
