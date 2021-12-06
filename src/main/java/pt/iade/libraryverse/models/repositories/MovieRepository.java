package pt.iade.libraryverse.models.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.CrudRepository;
import pt.iade.libraryverse.models.Movie;
import pt.iade.libraryverse.models.views.MovieInfoView;

public interface MovieRepository extends CrudRepository<Movie,Integer>
{
    String QueryGetMovieInfo = "select movie_name as movieName, movie_duration as duration, movie_date as date, movie_description as description, cu_name as cinematicUniverse, genre_name as genre " +
    "from movie " +
    "left join cinematicuniverse on movie_cu_id = cu_id " +
    "inner join movieGenre on mg_movie_id = movie_id " +
    "inner join genre on mg_genre_id = genre_id ";

    @Query(value = QueryGetMovieInfo + " where movie_id=:id", nativeQuery = true)
    Iterable<MovieInfoView> getMovieInfo(@Param("id") int id);
}
