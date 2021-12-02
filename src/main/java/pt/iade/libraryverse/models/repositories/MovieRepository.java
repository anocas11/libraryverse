package pt.iade.libraryverse.models.repositories;

import org.springframework.data.repository.CrudRepository;
import pt.iade.libraryverse.models.Movie;
import pt.iade.libraryverse.models.views.MovienfoView;

public interface MovieRepository extends CrudRepository<Movie,Integer>
{
    String QueryGetMovieInfo = "select movie_name as movieName, movie_duration as duration, movie_date as date, movie_description as description, cu_name as cinematicUniverse " + 
    "from movie " + 
    "inner join cinematicuniverse on movie_cu_id = cu_id ";

    @Query(value = QueryGetMovieInfo +
    " where movie_id=:id", nativeQuery = true)
    Iterable<MovienfoView> getMovie(@Param("id") int id);
}
