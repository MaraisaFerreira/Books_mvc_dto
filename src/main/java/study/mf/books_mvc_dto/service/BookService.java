package study.mf.books_mvc_dto.service;

import org.springframework.stereotype.Service;
import study.mf.books_mvc_dto.dto.response.BookResponseDto;
import study.mf.books_mvc_dto.entities.Book;
import study.mf.books_mvc_dto.repository.BookRepository;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookResponseDto> findAll(){
        return bookRepository.findAll().stream().map(BookResponseDto::new).toList();
    }

    public List<BookResponseDto> findByTitle(String title){
        return bookRepository.findByTitle(title).stream().map(BookResponseDto::new).toList();
    }

    public BookResponseDto findByTitleAndAuthor(String title, String author){
        Book book = bookRepository.findByTitleAndAuthor(title, author)
                .orElseThrow(() -> new RuntimeException("Book  not found"));

        return new BookResponseDto(book);
    }
}
