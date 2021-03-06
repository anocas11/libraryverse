package pt.iade.libraryverse.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import pt.iade.libraryverse.models.Book;
import pt.iade.libraryverse.models.UserBooks;
import pt.iade.libraryverse.models.Response;
import pt.iade.libraryverse.models.Status;
import pt.iade.libraryverse.models.repositories.BookRepository;
import pt.iade.libraryverse.models.repositories.UserBooksRepository;
import pt.iade.libraryverse.models.repositories.CinematicUniverseRepository;
import pt.iade.libraryverse.models.views.BookAuthorsView;
import pt.iade.libraryverse.models.views.BookCharactersView;
import pt.iade.libraryverse.models.views.BookInfoView;
import pt.iade.libraryverse.models.views.UserBooksStatusView;
import pt.iade.libraryverse.models.exceptions.NotFoundException;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping(path = "api/books")
public class BookController {
    private Logger logger = LoggerFactory.getLogger(BookController.class);

    //usamos os métodos que já existem no CRUDRepository interface com a ajuda da anotação autowired
    @Autowired
    private BookRepository bookRepository;

    
    @Autowired
    private UserBooksRepository ubRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Book> getBooks()
    {
        logger.info("Sending all books");
        return bookRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Book getBook(@PathVariable int id) 
    {
        logger.info("Sending book with id " + id);
        Optional<Book> _book = bookRepository.findById(id);
        if (_book.isEmpty())
        {
            //Confirmar que o livro existe
            throw new NotFoundException( "Book", "id", "" + id);
        }
        else 
        {
            return _book.get();
        }
    }

    @GetMapping(path = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<List<Book>> getBookByName(@RequestParam String name) 
    {
        logger.info("Sending books with name " + name);
        Iterable<Book> _book = bookRepository.findAll();
        
        //Adapted from 'https://www.baeldung.com/java-convert-iterator-to-list'
        List<Book> booksList = new ArrayList<Book>();
        //para cada livro encontrado que contenha a string descrita na pesquisa vai ser guardado na booklist
        _book.forEach(book -> {
            if(book.getName().contains(name))
            {
                booksList.add(book);
            }
        });

        var resp = new Response<List<Book>>();
        resp.results = booksList;

        return resp;
    }

    @GetMapping(path = "/book/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Iterable<BookInfoView>> getBookInfo(@PathVariable int id)
    {
        var resp = new Response<Iterable<BookInfoView>>();
        resp.results = bookRepository.getBookInfo(id);
        return resp;
    }

    @GetMapping(path = "/book/{id}/authors", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Iterable<BookAuthorsView>> getBookAuthors(@PathVariable int id)
    {
        var resp = new Response<Iterable<BookAuthorsView>>();
        resp.results = bookRepository.getBookAuthors(id);
        return resp;
    }

    @GetMapping(path = "/book/{id}/characters", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Iterable<BookCharactersView>> getBookCharacters(@PathVariable int id)
    {
        var resp = new Response<Iterable<BookCharactersView>>();
        resp.results = bookRepository.getBookCharacters(id);
        return resp;
    }

    @GetMapping(path = "/book/{bookid}/{userid}/status", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserBooks getUserBookStatus(@PathVariable int bookid, @PathVariable int userid)
    {
        Iterable<UserBooksStatusView> books = ubRepository.getUserBooks(bookid, userid);

        List<UserBooksStatusView> userBooks = new ArrayList<UserBooksStatusView>();

        books.forEach(book ->{
            userBooks.add(book);
        });

        if(userBooks.size() == 0)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "");
        }
        else 
        {
            UserBooks ubToReturn = new UserBooks();
            ubToReturn.setId(userBooks.get(0).getId());
            ubToReturn.setUserId(userid);
            ubToReturn.setBookId(bookid);
            ubToReturn.setFavorite(userBooks.get(0).getFavorite());
            ubToReturn.setRead(userBooks.get(0).getRead());
            ubToReturn.setReading(userBooks.get(0).getReading());
            ubToReturn.setHas(userBooks.get(0).getHas());

            return ubToReturn;
        }
    } 

    @PostMapping(path = "/book/{bookid}/{userid}/favorite", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserBooks saveToFavorites(@PathVariable int bookid, @PathVariable int userid)
    {
        Iterable<UserBooksStatusView> books = ubRepository.getUserBooks(bookid, userid);

        List<UserBooksStatusView> userBooks = new ArrayList<UserBooksStatusView>();

        books.forEach(book ->{
            userBooks.add(book);
        });

        if(userBooks.size() == 0)
        {
            UserBooks ubToInsert = new UserBooks();
            ubToInsert.setUserId(userid);
            ubToInsert.setBookId(bookid);
            ubToInsert.setFavorite(true);
            ubToInsert.setRead(false);
            ubToInsert.setReading(false);
            ubToInsert.setHas(false);

            ubRepository.save(ubToInsert);

            return ubToInsert;
        }
        else 
        {
            UserBooks ubToUpdate = new UserBooks();
            ubToUpdate.setId(userBooks.get(0).getId());
            ubToUpdate.setUserId(userid);
            ubToUpdate.setBookId(bookid);
            ubToUpdate.setFavorite(!userBooks.get(0).getFavorite());
            ubToUpdate.setRead(userBooks.get(0).getRead());
            ubToUpdate.setReading(userBooks.get(0).getReading());
            ubToUpdate.setHas(userBooks.get(0).getHas());

            ubRepository.save(ubToUpdate);

            return ubToUpdate;
        }
    } 

    @PostMapping(path = "/book/{bookid}/{userid}/read", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserBooks saveToRead(@PathVariable int bookid, @PathVariable int userid)
    {
        Iterable<UserBooksStatusView> books = ubRepository.getUserBooks(bookid, userid);

        List<UserBooksStatusView> userBooks = new ArrayList<UserBooksStatusView>();

        books.forEach(book ->{
            userBooks.add(book);
        });

        if(userBooks.size() == 0)
        {
            UserBooks ubToInsert = new UserBooks();
            ubToInsert.setUserId(userid);
            ubToInsert.setBookId(bookid);
            ubToInsert.setFavorite(false);
            ubToInsert.setRead(true);
            ubToInsert.setReading(false);
            ubToInsert.setHas(false);

            ubRepository.save(ubToInsert);

            return ubToInsert;
        }
        else 
        {
            UserBooks ubToUpdate = new UserBooks();
            ubToUpdate.setId(userBooks.get(0).getId());
            ubToUpdate.setUserId(userid);
            ubToUpdate.setBookId(bookid);
            ubToUpdate.setFavorite(userBooks.get(0).getFavorite());
            ubToUpdate.setRead(!userBooks.get(0).getRead());
            ubToUpdate.setReading(userBooks.get(0).getReading());
            ubToUpdate.setHas(userBooks.get(0).getHas());

            ubRepository.save(ubToUpdate);

            return ubToUpdate;
        }
    } 

    @PostMapping(path = "/book/{bookid}/{userid}/reading", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserBooks saveToReading(@PathVariable int bookid, @PathVariable int userid)
    {
        Iterable<UserBooksStatusView> books = ubRepository.getUserBooks(bookid, userid);

        List<UserBooksStatusView> userBooks = new ArrayList<UserBooksStatusView>();

        books.forEach(book ->{
            userBooks.add(book);
        });

        if(userBooks.size() == 0)
        {
            UserBooks ubToInsert = new UserBooks();
            ubToInsert.setUserId(userid);
            ubToInsert.setBookId(bookid);
            ubToInsert.setFavorite(false);
            ubToInsert.setRead(false);
            ubToInsert.setReading(true);
            ubToInsert.setHas(false);

            ubRepository.save(ubToInsert);

            return ubToInsert;
        }
        else 
        {
            UserBooks ubToUpdate = new UserBooks();
            ubToUpdate.setId(userBooks.get(0).getId());
            ubToUpdate.setUserId(userid);
            ubToUpdate.setBookId(bookid);
            ubToUpdate.setFavorite(userBooks.get(0).getFavorite());
            ubToUpdate.setRead(userBooks.get(0).getRead());
            ubToUpdate.setReading(!userBooks.get(0).getReading());
            ubToUpdate.setHas(userBooks.get(0).getHas());

            ubRepository.save(ubToUpdate);

            return ubToUpdate;
        }
    } 

    @PostMapping(path = "/book/{bookid}/{userid}/owned", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserBooks saveToOwned(@PathVariable int bookid, @PathVariable int userid)
    {
        Iterable<UserBooksStatusView> books = ubRepository.getUserBooks(bookid, userid);

        List<UserBooksStatusView> userBooks = new ArrayList<UserBooksStatusView>();

        books.forEach(book ->{
            userBooks.add(book);
        });

        if(userBooks.size() == 0)
        {
            UserBooks ubToInsert = new UserBooks();
            ubToInsert.setUserId(userid);
            ubToInsert.setBookId(bookid);
            ubToInsert.setFavorite(false);
            ubToInsert.setRead(false);
            ubToInsert.setReading(false);
            ubToInsert.setHas(true);

            ubRepository.save(ubToInsert);

            return ubToInsert;
        }
        else 
        {
            UserBooks ubToUpdate = new UserBooks();
            ubToUpdate.setId(userBooks.get(0).getId());
            ubToUpdate.setUserId(userid);
            ubToUpdate.setBookId(bookid);
            ubToUpdate.setFavorite(userBooks.get(0).getFavorite());
            ubToUpdate.setRead(userBooks.get(0).getRead());
            ubToUpdate.setReading(userBooks.get(0).getReading());
            ubToUpdate.setHas(!userBooks.get(0).getHas());

            ubRepository.save(ubToUpdate);

            return ubToUpdate;
        }
    } 
}
