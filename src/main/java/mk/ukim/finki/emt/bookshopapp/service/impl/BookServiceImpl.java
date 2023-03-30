package mk.ukim.finki.emt.bookshopapp.service.impl;

import mk.ukim.finki.emt.bookshopapp.model.Author;
import mk.ukim.finki.emt.bookshopapp.model.Book;
import mk.ukim.finki.emt.bookshopapp.model.dto.BookDto;
import mk.ukim.finki.emt.bookshopapp.model.enumerations.Category;
import mk.ukim.finki.emt.bookshopapp.model.exception.AuthorNotFoundException;
import mk.ukim.finki.emt.bookshopapp.model.exception.BookNotFoundException;
import mk.ukim.finki.emt.bookshopapp.model.exception.NoAvailableCopiesLeftException;
import mk.ukim.finki.emt.bookshopapp.repository.AuthorRepository;
import mk.ukim.finki.emt.bookshopapp.repository.BookRepository;
import mk.ukim.finki.emt.bookshopapp.repository.CountryRepository;
import mk.ukim.finki.emt.bookshopapp.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public Optional<Book> save(BookDto book) {
        Author author = authorRepository.findById(book.getAuthor()).orElseThrow(() -> new AuthorNotFoundException(book.getAuthor()));

        this.bookRepository.deleteByName(book.getName());
        Book b = new Book(book.getName(), book.getCategory(), author, book.getAvailableCopies());
        bookRepository.save(b);

        return Optional.of(b);
    }

    @Override
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Optional<Book> update(BookDto book, Long id) {
        Book b = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));

        b.setName(book.getName());
        b.setAvailableCopies(book.getAvailableCopies());
        b.setCategory(Category.valueOf(book.getCategory()));

        Author author = authorRepository.findById(book.getAuthor()).orElseThrow(() -> new AuthorNotFoundException(book.getAuthor()));
        b.setAuthor(author);

        bookRepository.save(b);

        return Optional.of(b);
    }

    @Override
    public List<Category> listAllCategories() {
        return List.of(Category.values());
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void markAsTaken(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        if(book.getAvailableCopies() > 0){
            book.setAvailableCopies(book.getAvailableCopies() - 1);
            bookRepository.save(book);
        }
        else
            throw new NoAvailableCopiesLeftException(id);
    }
}
