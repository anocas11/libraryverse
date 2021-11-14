package pt.iade.libraryverse.models.repositories;

import org.springframework.data.repository.CrudRepository;
import pt.iade.libraryverse.models.Book;

public interface BookRepository extends CrudRepository<Book,Integer> {
}
