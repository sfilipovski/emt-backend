package mk.ukim.finki.emt.bookshopapp.service;

import mk.ukim.finki.emt.bookshopapp.model.Book;
import mk.ukim.finki.emt.bookshopapp.model.dto.BookDto;
import mk.ukim.finki.emt.bookshopapp.model.enumerations.Category;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Optional<Book> save(BookDto b);
    List<Book> findAllBooks();
    Optional<Book> findById(Long id);
    Optional<Book> update(BookDto book, Long id);
    List<Category> listAllCategories();
    void deleteById(Long id);
    void markAsTaken(Long id);
}
