package mk.ukim.finki.emt.bookshopapp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    private String name;
    private String category;
    private Long author;
    private Integer availableCopies;
}
