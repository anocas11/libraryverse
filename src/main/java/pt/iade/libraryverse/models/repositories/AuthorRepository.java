package pt.iade.libraryverse.models.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.CrudRepository;

import pt.iade.libraryverse.models.views.AuthorBooksView;
import pt.iade.libraryverse.models.repositories.AuthorRepository;
import pt.iade.libraryverse.models.Author;

public interface AuthorRepository extends CrudRepository<Author,Integer> {
    String QueryGetAuthorBooks = "select book_name as bookName from book " +
    "inner join bookauthor on book_id = ba_book_id ";

    @Query(value = QueryGetAuthorBooks + " where ba_author_id=:id", nativeQuery = true)
    Iterable<AuthorBooksView> getAuthorBooks(@Param("id") int id);
}
