package pt.iade.libraryverse.models.repositories;

import org.springframework.data.repository.CrudRepository;
import pt.iade.libraryverse.models.Movie;

public interface MovieRepository extends CrudRepository<Movie,Integer>{
    
}
