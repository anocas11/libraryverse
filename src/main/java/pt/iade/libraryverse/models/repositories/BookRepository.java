package pt.iade.libraryverse.models.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.CrudRepository;
import pt.iade.libraryverse.models.Book;
import pt.iade.libraryverse.models.views.BookInfoView;
import pt.iade.libraryverse.models.views.MovieInfoView;

public interface BookRepository extends CrudRepository<Book,Integer> 
{
    //Criamos a interface que extende CrudRepository que contem todas as funções crud do springboot
    //Os parâmetros significam que o repositório vai gerir os livros e o id dos livros é um int 

    String QueryGetBookInfo = "select book_name as bookName, book_date as date, book_description as description, book_poster as poster, cu_name as cinematicUniverse " + 
    "from book " +
    "inner join cinematicuniverse on book_cu_id = cu_id " +
    "inner join bookGenre on bg_book_id = book_id " +
    "inner join genre on bg_genre_id = genre_id ";

    @Query(value = QueryGetBookInfo + " where book_id=:id", nativeQuery = true)
    Iterable<BookInfoView> getBookInfo(@Param("id") int id);
}
