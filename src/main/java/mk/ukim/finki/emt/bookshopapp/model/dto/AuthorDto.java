package mk.ukim.finki.emt.bookshopapp.model.dto;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mk.ukim.finki.emt.bookshopapp.model.Country;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDto {
    private String name;
    private String surname;
    private Long country;
}
