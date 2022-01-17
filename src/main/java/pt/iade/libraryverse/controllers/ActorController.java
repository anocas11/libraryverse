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

import pt.iade.libraryverse.models.Actor;
import pt.iade.libraryverse.models.Response;
import pt.iade.libraryverse.models.repositories.ActorRepository;
import pt.iade.libraryverse.models.views.ActorMoviesView;
import pt.iade.libraryverse.models.exceptions.NotFoundException;

@RestController
@RequestMapping(path = "api/actors")
public class ActorController {
    private Logger logger = LoggerFactory.getLogger(ActorController.class);

    @Autowired
    private ActorRepository actorRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Actor> getActors()
    {
        logger.info("Sending all actors");
        return actorRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Actor> getActor(@PathVariable int id)
    {
        logger.info("Sending actor with id" + id);
        Optional<Actor> _actor = actorRepository.findById(id);
        if(_actor.isEmpty())
        {
            throw new NotFoundException("Actor", "id", "" + id);
        }
        else
        {
            var resp = new Response<Actor>();
            resp.results = _actor.get();
            return resp;
        }
    }

    @GetMapping(path = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<List<Actor>> getActorByName(@RequestParam String name)
    {
        logger.info("Sending actors with name " + name);
        Iterable<Actor> _actor = actorRepository.findAll();

        List<Actor> actorsList = new ArrayList<Actor>();
        _actor.forEach(actor -> {
            if(actor.getName().contains(name))
            {
                actorsList.add(actor);
            }
        });

        var resp = new Response<List<Actor>>();
        resp.results = actorsList;

        return resp;
    }

    @GetMapping(path = "/actor/{id}/movies", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Iterable<ActorMoviesView>> getActorMovies(@PathVariable int id)
    {
        var resp = new Response<Iterable<ActorMoviesView>>();
        resp.results = actorRepository.getActorMovies(id);
        return resp;
    }
}
