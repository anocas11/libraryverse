package pt.iade.libraryverse.models.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import pt.iade.libraryverse.models.User;
import pt.iade.libraryverse.models.views.UserBooksView;
import pt.iade.libraryverse.models.views.UserMoviesView;

public interface UserRepository extends CrudRepository<User,Integer>{
    Optional<User> findByUsername(String username);
    
    String QueryGetUserBooks = "select book_name as bookName, book_poster as bookPoster from book " +
    "inner join userbooks on book_id = ub_book_id ";

    @Query(value = QueryGetUserBooks + " where ub_user_id =:id", nativeQuery = true)
    Iterable<UserBooksView> getUserBooks(@Param("id") int id);

    String QueryGetUserMovies = "select movie_name as movieName, movie_poster as moviePoster from movie " +
    "inner join usermovies on movie_id = um_movie_id ";

    @Query(value = QueryGetUserMovies + " where um_user_id =:id", nativeQuery = true)
    Iterable<UserMoviesView> getUserMovies(@Param("id") int id);

    String QueryGetUserFavoriteBooks = "select book_name as bookName, book_poster as bookPoster from book " +
    "inner join userbooks on book_id = ub_book_id " +
    "where ub_favorite = true and ";

    @Query(value = QueryGetUserFavoriteBooks + " where ub_user_id =:id", nativeQuery = true)
    Iterable<UserBooksView> getUserFavoriteBooks(@Param("id") int id);

    String QueryGetUserLastBooks = "select book_name as bookName, book_poster as bookPoster from book " +
    "inner join userbooks on book_id = ub_book_id " +
    "order by ub_timestamp " +
    "limit 3 ";

    @Query(value = QueryGetUserLastBooks + " where ub_user_id =:id", nativeQuery = true)
    Iterable<UserBooksView> getUserLastBooks(@Param("id") int id);

    String QueryGetUserFavoriteMovies = "select movie_name as movieName, movie_poster as moviePoster from movie " +
    "inner join usermovies on movie_id = um_movie_id " +
    "where um_favorite = true and ";

    @Query(value = QueryGetUserMovies + " where um_user_id =:id", nativeQuery = true)
    Iterable<UserMoviesView> getUserFavoriteMovies(@Param("id") int id);

    String QueryGetUserLastMovies = "select movie_name as movieName, movie_poster as moviePoster from movie " +
    "inner join usermovies on movie_id = um_movie_id " +
    "order by um_timestamp " +
    "limit 3 ";

    @Query(value = QueryGetUserLastMovies + " where ub_user_id =:id", nativeQuery = true)
    Iterable<UserMoviesView> getUserLastMovies(@Param("id") int id);
}
