package mk.ukim.finki.emt.bookshopapp.repository;

import mk.ukim.finki.emt.bookshopapp.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    void deleteByName(String name);
}
