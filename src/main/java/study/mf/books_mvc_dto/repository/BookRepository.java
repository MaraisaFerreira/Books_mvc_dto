package study.mf.books_mvc_dto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.mf.books_mvc_dto.entities.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByTitle(String title);
    Optional<Book> findByTitleAndAuthor(String title, String author);
}
