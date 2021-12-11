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

import pt.iade.libraryverse.models.User;
import pt.iade.libraryverse.models.repositories.UserRepository;
import pt.iade.libraryverse.models.exceptions.NotFoundException;

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

    /*@PostMapping(path="", produces = MediaType.APPLICATION_JSON_VALUE)
    public User saveUser(@RequestBody String username, String password)
    {

    }*/
     
}
