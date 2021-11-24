package pt.iade.libraryverse.models.repositories;

import org.springframework.data.repository.CrudRepository;
import pt.iade.libraryverse.models.Genre;

public interface GenreRepository extends CrudRepository<Genre,Integer>{
    
}
