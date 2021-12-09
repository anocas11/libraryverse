package pt.iade.libraryverse.models.repositories;

import org.springframework.data.repository.CrudRepository;
import pt.iade.libraryverse.models.Actor;
public interface ActorRepository extends CrudRepository<Actor,Integer> {
    
}
