package study.mf.books_mvc_dto.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"title", "author"})
@Entity
@Table(
        name = "books",
        uniqueConstraints = {
                @UniqueConstraint(name = "title_and_author", columnNames = {"title", "author"})
        }
)
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false, length = 100)
    private String author;
    @Column(nullable = false)
    private Integer releaseYear;
}
