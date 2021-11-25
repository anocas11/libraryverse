package pt.iade.libraryverse.models.repositories;

import org.springframework.data.repository.CrudRepository;
import pt.iade.libraryverse.models.Author;

public interface AuthorRepository extends CrudRepository<Author,Integer> {
    
}
