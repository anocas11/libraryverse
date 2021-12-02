package pt.iade.libraryverse.models.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.CrudRepository;
import pt.iade.libraryverse.models.Genre;
import pt.iade.libraryverse.models.views.GenreView;

public interface GenreRepository extends CrudRepository<Genre,Integer>
{
    String QueryGetMovieGenre = 
    "select genre_name genreName from genre " +
    "inner join moviegenre on genre_id = mg_genre_id " +
    "inner join movie on mg_movie_id = movie_id";

    @Query(value = QueryGetMovieGenre + " where movie_id=:id", nativeQuery = true)
    Iterable<GenreView> findGenreByMovie(@Param("id") int id);

    String QueryGetBookGenre = 
    "select genre_name genreName from genre " +
    "inner join bookgenre on genre_id = bg_genre_id " +
    "inner join book on bg_book_id = book_id";

    @Query(value = QueryGetBookGenre + " where book_id=:id", nativeQuery = true)
    Iterable<GenreView> findGenreByBook(@Param("id") int id);
}   
