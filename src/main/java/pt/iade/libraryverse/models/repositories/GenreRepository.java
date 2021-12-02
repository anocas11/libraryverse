package pt.iade.libraryverse.models.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import pt.iade.libraryverse.models.Genre;
import pt.iade.libraryverse.models.views.GenreView;

public interface GenreRepository extends CrudRepository<Genre,Integer>
{
    List<Genre> getGenre(int id); 

    String QueryGetItemGenre = 
    "select genre_name genreName, movie_name movieName from genre "+
    "inner join moviegenre on genre_id = mg_genre_id "+
    "inner join movie on mg_movie_id = movie_id";

    @Query(value = QueryGetItemGenre + 
    " where movie_name=:mname", nativeQuery = true)
    Iterable<GenreView> findGenreByMovieName(@Param("mname") String mname);

}   
