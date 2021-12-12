package pt.iade.libraryverse.models.repositories;

import org.springframework.data.repository.CrudRepository;
import pt.iade.libraryverse.models.Actor;
import pt.iade.libraryverse.models.views.ActorMoviesView;
import pt.iade.libraryverse.models.repositories.ActorRepository;

public interface ActorRepository extends CrudRepository<Actor,Integer> {
    //String QueryGetActorMovies = "";

    //@Query(value = QueryGetActorMovies + "where =:id", nativeQuery = true)
    //Iterable<ActorMoviesView> getActorMovies(@Param("id") int id);
}
