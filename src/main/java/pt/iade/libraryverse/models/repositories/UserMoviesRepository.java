package pt.iade.libraryverse.models.repositories;

import org.springframework.data.repository.CrudRepository;
import pt.iade.libraryverse.models.UserMovies;
import pt.iade.libraryverse.models.views.UserMoviesStatusView;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserMoviesRepository extends CrudRepository<UserMovies, Integer>
{
        //Criamos a interface que extende CrudRepository que contem todas as funções crud do springboot
        //Os parâmetros significam que o repositório vai gerir os filmes dos utilizadores e o id dos filmes dos utilizadores é um int 

        String QueryGetUserMovies = "select um_id as id, um_favorite as favorite, um_watched as watched, um_has as has from usermovies ";

        @Query(value = QueryGetUserMovies + "where um_user_id=:userid and um_movie_id=:movieid", nativeQuery = true)
        Iterable<UserMoviesStatusView> getUserMovies(@Param("movieid") int movieid, @Param("userid") int userId);
}
