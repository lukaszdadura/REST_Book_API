package pl.lukaszdadura.bookapi.service;

import org.springframework.stereotype.Component;
import pl.lukaszdadura.bookapi.model.Book;

import java.util.ArrayList;
import java.util.List;

@Component
public class MockBookService {

    private List<Book> list;
    private static Long nextId = 4L;


    public MockBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thiniking	in	Java", "Bruce	Eckel", "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz	glowa	Java.", "Sierra	Kathy,	Bates	Bert", "Helion",
                "programming"));
        list.add(new Book(3L, "9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion",
                "programming"));
    }

    public List<Book> getList() {
        return list;
    }

    public void setList(List<Book> list) {
        this.list = list;
    }

    public List<Book> getAllBooks() {
        return list;
    }

    public Book getBookById(Long id) {
        for (Book book : list) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    public void addBook(Book book) {
        book.setId(nextId);
        list.add(book);
        nextId++;
    }

    public void editBook(Book book) {
        int index=-1;
        for (Book bookToFind : list) {
            if(bookToFind.getId() == book.getId()) {
                index = list.indexOf(bookToFind);
            }
            list.set(index, book);
        }
    }

    public void removeBookById(Long id) {
        list.removeIf((el)-> el.getId() == id);
    }
}
