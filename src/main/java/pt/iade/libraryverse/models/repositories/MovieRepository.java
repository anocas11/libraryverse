package pt.iade.libraryverse.models.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.CrudRepository;
import pt.iade.libraryverse.models.Movie;
import pt.iade.libraryverse.models.views.MovieActorsView;
import pt.iade.libraryverse.models.views.MovieCharactersView;
import pt.iade.libraryverse.models.views.MovieInfoView;

public interface MovieRepository extends CrudRepository<Movie,Integer>
{
    String QueryGetMovieInfo = "select movie_name as name, movie_duration as duration, movie_date as date, movie_description as description, cu_name as cinematicUniverse, genre_name as genre, movie_poster as poster " +
    "from movie " +
    "left join cinematicuniverse on movie_cu_id = cu_id " +
    "inner join movieGenre on mg_movie_id = movie_id " +
    "inner join genre on mg_genre_id = genre_id ";

    @Query(value = QueryGetMovieInfo + " where movie_id=:id", nativeQuery = true)
    Iterable<MovieInfoView> getMovieInfo(@Param("id") int id);

    String QueryGetMovieCharacters = "select character_name as characterName " + 
    "from character " +
    "inner join moviecharacter on character_id = mc_character_id ";

    @Query(value = QueryGetMovieCharacters + " where mc_movie_id=:id", nativeQuery = true)
    Iterable<MovieCharactersView> getMovieCharacters(@Param("id") int id);

    String QueryGetMovieActors = "select actor_name as actorName from actorName " +
    "inner join movieactor on actor_id = ma_actor_id " +
    "inner join moviecharacter on ma_mc_id = mc_id ";

    @Query(value = QueryGetMovieActors + "where mc_movie_id=:id", nativeQuery = true)
    Iterable<MovieActorsView> getMovieActors(@Param("id") int id);
}
