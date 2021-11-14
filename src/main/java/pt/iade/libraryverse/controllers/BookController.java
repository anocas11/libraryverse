package pt.iade.libraryverse.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import pt.iade.libraryverse.models.Book;
import pt.iade.libraryverse.models.repositories.BookRepository;

@RestController
@RequestMapping(path = "api/books")
public class BookController {
    private Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookRepository bookRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Book> getBooks()
    {
        logger.info("Sending all books");
        return bookRepository.findAll();
    }

    //find book by id

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Book saveBook(@RequestBody Book book)
    {
        Book savedBook = bookRepository.save(book);
        logger.info("Saving book with id " +savedBook.getId());
        return savedBook;
    }

}
