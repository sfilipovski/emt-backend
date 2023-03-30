package mk.ukim.finki.emt.bookshopapp.web;

import mk.ukim.finki.emt.bookshopapp.model.Author;
import mk.ukim.finki.emt.bookshopapp.model.Book;
import mk.ukim.finki.emt.bookshopapp.model.dto.BookDto;
import mk.ukim.finki.emt.bookshopapp.model.enumerations.Category;
import mk.ukim.finki.emt.bookshopapp.service.AuthorService;
import mk.ukim.finki.emt.bookshopapp.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
@RequestMapping("/api/books")
public class BookRestController {

    private final BookService bookService;
    private final AuthorService authorService;

    public BookRestController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping("/")
    public List<Book> findAll(){
        return bookService.findAllBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id){
        return bookService.findById(id)
                .map(b -> ResponseEntity.ok().body(b))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Book> save(@RequestBody BookDto book){
        return bookService.save(book)
                .map(b -> ResponseEntity.ok().body(b))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Book> save(@PathVariable Long id, @RequestBody BookDto book) {
        return this.bookService.update(book, id)
                .map(b -> ResponseEntity.ok().body(b))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Book> deleteById(@PathVariable Long id){
        bookService.deleteById(id);
        if(bookService.findById(id).isEmpty()) return ResponseEntity.ok().build();
        else return ResponseEntity.badRequest().build();
    }

    @PutMapping("/mark/{id}")
    public void markAsTaken(@PathVariable Long id) {
        bookService.markAsTaken(id);
    }

    @GetMapping("/authors")
    public List<Author> getAllAuthors(){
        return authorService.findAll();
    }

    @GetMapping("/categories")
    public List<Category> getAllCategories(){
        return bookService.listAllCategories();
    }
}
