package mk.ukim.finki.emt.bookshopapp.repository;

import mk.ukim.finki.emt.bookshopapp.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    void deleteByName(String name);
}
