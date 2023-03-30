package mk.ukim.finki.emt.bookshopapp.service;

import mk.ukim.finki.emt.bookshopapp.model.Author;
import mk.ukim.finki.emt.bookshopapp.model.dto.AuthorDto;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    Optional<Author> save(AuthorDto author);
    List<Author> findAll();
    Optional<Author> findById(Long id);
    Optional<Author> update(AuthorDto author, Long id);
    void deleteById(Long id);
}
