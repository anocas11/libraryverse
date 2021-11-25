package pt.iade.libraryverse.models.repositories;

import org.springframework.data.repository.CrudRepository;
import pt.iade.libraryverse.models.Character;

public interface CharacterRepository extends CrudRepository<Character,Integer>{
    
}
