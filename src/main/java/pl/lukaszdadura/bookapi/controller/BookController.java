package pl.lukaszdadura.bookapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.lukaszdadura.bookapi.model.Book;
import pl.lukaszdadura.bookapi.service.MockBookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    MockBookService mockBookService;

    @Autowired
    public BookController(MockBookService mockBookService) {
        this.mockBookService = mockBookService;
    }

    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }

    @RequestMapping("")
    public List<Book> getAllBooks() {
        return mockBookService.getAllBooks();
    }

    @RequestMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return mockBookService.getBookById(id);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public void addBook(@RequestBody Book book) {
        mockBookService.addBook(book);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public void editBook(@RequestBody Book book) {
        mockBookService.editBook(book);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void removeBook(@PathVariable Long id) {
        mockBookService.removeBookById(id);
    }


}
