package main.java.pt.iade.libraryverse.models.repositories;

import org.springframework.data.repository.CrudRepository;
import main.java.pt.iade.libraryverse.models.Book;

public interface BookRepository extends CrudRepository<Book,Integer> {
    
}
