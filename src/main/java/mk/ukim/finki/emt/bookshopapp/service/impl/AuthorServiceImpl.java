package mk.ukim.finki.emt.bookshopapp.service.impl;

import mk.ukim.finki.emt.bookshopapp.model.Author;
import mk.ukim.finki.emt.bookshopapp.model.Book;
import mk.ukim.finki.emt.bookshopapp.model.Country;
import mk.ukim.finki.emt.bookshopapp.model.dto.AuthorDto;
import mk.ukim.finki.emt.bookshopapp.model.enumerations.Category;
import mk.ukim.finki.emt.bookshopapp.model.exception.AuthorNotFoundException;
import mk.ukim.finki.emt.bookshopapp.model.exception.BookNotFoundException;
import mk.ukim.finki.emt.bookshopapp.model.exception.CountryNotFoundException;
import mk.ukim.finki.emt.bookshopapp.repository.AuthorRepository;
import mk.ukim.finki.emt.bookshopapp.repository.CountryRepository;
import mk.ukim.finki.emt.bookshopapp.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public Optional<Author> save(AuthorDto author) {
        Country country = countryRepository.findById(author.getCountry()).orElseThrow(() -> new CountryNotFoundException(author.getCountry()));

        this.authorRepository.deleteByName(author.getName());
        Author a = new Author(author.getName(), author.getSurname(), country);
        authorRepository.save(a);

        return Optional.of(a);
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public Optional<Author> update(AuthorDto author, Long id) {
        Author a = authorRepository.findById(id).orElseThrow(() -> new AuthorNotFoundException(id));

        a.setName(author.getName());
        a.setSurname(a.getSurname());

        Country country = countryRepository.findById(author.getCountry()).orElseThrow(() -> new CountryNotFoundException(author.getCountry()));

        a.setCountry(country);

        authorRepository.save(a);

        return Optional.of(a);
    }

    @Override
    public void deleteById(Long id) {

    }
}
