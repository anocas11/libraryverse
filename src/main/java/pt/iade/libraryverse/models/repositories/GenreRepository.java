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
    String QueryGetItemGenre = 
    "select genre_name genreName from genre "+
    "inner join moviegenre on genre_id = mg_genre_id "+
    "inner join movie on mg_movie_id = movie_id";

    @Query(value = QueryGetItemGenre + 
    " where movie_name=:mname", nativeQuery = true)
    Iterable<GenreView> findGenreByMovieName(@Param("mname") String mname);

}   
