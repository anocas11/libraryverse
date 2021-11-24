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
import pt.iade.libraryverse.models.repositories.CinematicUniverseRepository;
import pt.iade.libraryverse.models.exceptions.NotFoundException;

@RestController
@RequestMapping(path = "api/cinematicuniverses")
public class CinematicUniverseController 
{
    private Logger logger = LoggerFactory.getLogger(CinematicUniverseController.class);
    
    @Autowired
    private CinematicUniverseRepository cuRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<CinematicUniverse> getCinematicUniverses()
    {
        logger.info("Sending all cinematic universes");
        return cuRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CinematicUniverse getCinematicUniverse(@PathVariable int id)
    {
        logger.info("Sending cinematic universes with id " + id);
        Optional<CinematicUniverse> _cu = cuRepository.findById(id);
        if(_cu.isEmpty())
        {
            throw new NotFoundException("Cinematic Universe", "id", "" + id);
        } 
        else
        {
            return _cu.get();
        }
    }
    
    @GetMapping(path = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CinematicUniverse> getCinematicUniverseByName(@RequestParam String name)
    {
        logger.info("Sending cinematic universes with name " + name);
        Iterable<CinematicUniverse> _cu = cuRepository.findAll();

        List<CinematicUniverse> cuList = new ArrayList<CinematicUniverse>();

        _cu.forEach(cinematicuniverse -> {
            if(cinematicuniverse.getName().contains(name))
            {
                cuList.add(cinematicuniverse);
            }
        });

        return cuList;
    }
}
