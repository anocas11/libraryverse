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

import pt.iade.libraryverse.models.Character;
import pt.iade.libraryverse.models.repositories.CharacterRepository;
import pt.iade.libraryverse.models.exceptions.NotFoundException;

@RestController
@RequestMapping(path = "api/characters")
public class CharacterController {
    private Logger logger = LoggerFactory.getLogger(CharacterController.class);

    @Autowired
    private CharacterRepository characterRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Character> getCharacters()
    {
        logger.info("Sending all characters");
        return characterRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Character getCharacter(@PathVariable int id)
    {
        logger.info("Sending character with id " + id);
        Optional<Character> _character = characterRepository.findById(id);
        if(_character.isEmpty())
        {
            throw new NotFoundException("Book", "id", "" + id);
        }
        else
        {
            return _character.get();
        }
    }

    @GetMapping(path = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Character> getCharacterByName(@RequestParam String name)
    {
        logger.info("Sending characters with name " + name);
        Iterable<Character> _character = characterRepository.findAll();

        
    }

    
}
