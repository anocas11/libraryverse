package pt.iade.libraryverse.models.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.CrudRepository;

import pt.iade.libraryverse.models.views.AuthorBooksView;
import pt.iade.libraryverse.models.repositories.AuthorRepository;
import pt.iade.libraryverse.models.Author;

public interface AuthorRepository extends CrudRepository<Author,Integer> {
    //Criamos a interface que extende CrudRepository que contem todas as funções crud do springboot
    //Os parâmetros significam que o repositório vai gerir os autores e o id dos autores é um int 

    Iterable<Author> getAuthorById(int id);

    String QueryGetAuthorBooks = "select book_name as bookName from book " +
    "inner join bookauthor on book_id = ba_book_id ";

    @Query(value = QueryGetAuthorBooks + " where ba_author_id=:id", nativeQuery = true)
    Iterable<AuthorBooksView> getAuthorBooks(@Param("id") int id);
}
