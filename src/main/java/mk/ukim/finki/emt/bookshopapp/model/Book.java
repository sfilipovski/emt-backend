package mk.ukim.finki.emt.bookshopapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mk.ukim.finki.emt.bookshopapp.model.enumerations.Category;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(value = EnumType.STRING)
    private Category category;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
    private Integer availableCopies;

    public void decreaseCopies(){
        this.availableCopies--;
    }

    public Book(String name, String category, Author author, Integer availableCopies){
        this.name = name;
        this.category = Category.valueOf(category);
        this.author = author;
        this.availableCopies = availableCopies;
    }

}
