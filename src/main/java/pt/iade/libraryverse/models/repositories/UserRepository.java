package pt.iade.libraryverse.models.repositories;

import org.springframework.data.repository.CrudRepository;
import pt.iade.libraryverse.models.User;

public interface UserRepository extends CrudRepository<User,Integer>{
    
}
