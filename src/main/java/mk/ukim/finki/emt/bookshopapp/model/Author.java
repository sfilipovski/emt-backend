package mk.ukim.finki.emt.bookshopapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    public Author(String name, String surname, Country country){
        this.name = name;
        this.surname = surname;
        this.country = country;
    }
}
