package pt.iade.libraryverse.models.repositories;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import pt.iade.libraryverse.models.User;

public interface UserRepository extends CrudRepository<User,Integer>{
    Optional<User> findByUsername(String username);
    
}
