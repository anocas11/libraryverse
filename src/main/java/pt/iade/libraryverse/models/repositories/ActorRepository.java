package pt.iade.libraryverse.models.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.CrudRepository;
import pt.iade.libraryverse.models.Actor;
import pt.iade.libraryverse.models.views.ActorMoviesView;
import pt.iade.libraryverse.models.repositories.ActorRepository;

public interface ActorRepository extends CrudRepository<Actor,Integer> {
    String QueryGetActorMovies = "select movie_name movieName from movie " +
    "inner join moviecharacter on movie_id = mc_movie_id " +
    "inner join movieactor on mc_id = ma_mc_id ";

    @Query(value = QueryGetActorMovies + "where ma_actor_id=:id", nativeQuery = true)
    Iterable<ActorMoviesView> getActorMovies(@Param("id") int id);
}
