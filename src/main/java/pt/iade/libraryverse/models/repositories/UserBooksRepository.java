package pt.iade.libraryverse.models.repositories;

import org.springframework.data.repository.CrudRepository;
import pt.iade.libraryverse.models.UserBooks;
import pt.iade.libraryverse.models.views.UserBooksStatusView;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserBooksRepository extends CrudRepository<UserBooks,Integer>
{
    String QueryGetUserBooks = "select ub_id as id, ub_favorite as favorite, ub_read as read, ub_reading as reading, ub_has as has " +
    " from userbooks ";

    @Query(value = QueryGetUserBooks + "where ub_user_id=:userid and ub_book_id=:bookid", nativeQuery = true)
    Iterable<UserBooksStatusView> getUserBooks(@Param("bookid") int bookId, @Param("userid") int userId);
}
