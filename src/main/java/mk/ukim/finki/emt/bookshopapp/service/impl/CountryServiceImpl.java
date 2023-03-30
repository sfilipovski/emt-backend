package mk.ukim.finki.emt.bookshopapp.service.impl;

import mk.ukim.finki.emt.bookshopapp.model.Country;
import mk.ukim.finki.emt.bookshopapp.model.dto.CountryDto;
import mk.ukim.finki.emt.bookshopapp.model.exception.CountryNotFoundException;
import mk.ukim.finki.emt.bookshopapp.repository.CountryRepository;
import mk.ukim.finki.emt.bookshopapp.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Optional<Country> save(CountryDto country) {
        countryRepository.deleteByName(country.getName());
        Country c = new Country(country.getName(), country.getContinent());

        countryRepository.save(c);

        return Optional.of(c);
    }

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return countryRepository.findById(id);
    }

    @Override
    public Optional<Country> update(CountryDto country, Long id) {
        Country c = countryRepository.findById(id).orElseThrow(() -> new CountryNotFoundException(id));

        c.setName(country.getName());
        c.setContinent(country.getContinent());

        countryRepository.save(c);

        return Optional.of(c);

    }

    @Override
    public void deleteById(Long id) {
        countryRepository.deleteById(id);
    }
}
