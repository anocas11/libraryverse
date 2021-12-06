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
import pt.iade.libraryverse.models.repositories.BookRepository;
import pt.iade.libraryverse.models.views.BookInfoView;
import pt.iade.libraryverse.models.exceptions.NotFoundException;

@RestController
@RequestMapping(path = "api/books")
public class BookController {
    private Logger logger = LoggerFactory.getLogger(BookController.class);

    //usamos os métodos que já existem no CRUDRepository interface com a ajuda da anotação autowired
    @Autowired
    private BookRepository bookRepository;

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
    public List<Book> getBookByName(@RequestParam String name) 
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

        return booksList;
    }

    @GetMapping(path = "/book/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<BookInfoView> getBookInfo(@PathVariable int id)
    {
        return bookRepository.getBookInfo(id);
    }
}
