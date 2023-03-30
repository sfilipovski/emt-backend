package mk.ukim.finki.emt.bookshopapp.init;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.emt.bookshopapp.model.Author;
import mk.ukim.finki.emt.bookshopapp.model.Book;
import mk.ukim.finki.emt.bookshopapp.model.Country;
import mk.ukim.finki.emt.bookshopapp.repository.AuthorRepository;
import mk.ukim.finki.emt.bookshopapp.repository.BookRepository;
import mk.ukim.finki.emt.bookshopapp.repository.CountryRepository;
import org.springframework.stereotype.Component;

@Component
public class Initializer {

    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;
    private final BookRepository bookRepository;

    public Initializer(AuthorRepository authorRepository, CountryRepository countryRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
        this.bookRepository = bookRepository;
    }

    @PostConstruct
    public void init(){
        Country c = new Country("France", "Europe");
        Author a = new Author("Peter","Pan",c);
        Book b = new Book("Book1","NOVEL",a,5);
        countryRepository.save(c);
        authorRepository.save(a);
        bookRepository.save(b);

        Country c1 = new Country("England", "Europe");
        Author a1 = new Author("Ricky","Martin",c);
        Book b1 = new Book("Book2","FANTASY",a,5);
        bookRepository.save(b1);
        countryRepository.save(c1);
        authorRepository.save(a1);

        Country c2 = new Country("China", "Asia");
        Author a2 = new Author("Zhu","Su",c);
        Book b3 = new Book("Book3","DRAMA",a,5);
        bookRepository.save(b3);
        countryRepository.save(c2);
        authorRepository.save(a2);





    }
}
