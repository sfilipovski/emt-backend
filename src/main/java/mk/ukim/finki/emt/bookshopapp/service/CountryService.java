package mk.ukim.finki.emt.bookshopapp.service;

import mk.ukim.finki.emt.bookshopapp.model.Author;
import mk.ukim.finki.emt.bookshopapp.model.Country;
import mk.ukim.finki.emt.bookshopapp.model.dto.CountryDto;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    Optional<Country> save(CountryDto country);
    List<Country> findAll();
    Optional<Country> findById(Long id);
    Optional<Country> update(CountryDto country, Long id);
    void deleteById(Long id);
}
