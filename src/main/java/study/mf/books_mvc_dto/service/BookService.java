package study.mf.books_mvc_dto.service;

import ch.qos.logback.core.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.mf.books_mvc_dto.dto.request.AddBookRequestDto;
import study.mf.books_mvc_dto.dto.request.UpdateBookRequestDto;
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

    @Transactional(readOnly = true)
    public List<BookResponseDto> findAll() {
        return bookRepository.findAll().stream().map(BookResponseDto::new).toList();
    }

    @Transactional(readOnly = true)
    public List<BookResponseDto> findByTitle(String title) {
        return bookRepository.findByTitle(title).stream().map(BookResponseDto::new).toList();
    }

    @Transactional(readOnly = true)
    public BookResponseDto findByTitleAndAuthor(String title, String author) {
        Book book = bookRepository.findByTitleAndAuthor(title, author)
                .orElseThrow(() -> new RuntimeException("Book  not found"));

        return new BookResponseDto(book);
    }

    @Transactional
    public BookResponseDto saveBook(AddBookRequestDto requestDto) {
        Book book = bookRepository.save(
                new Book(
                        null,
                        requestDto.title(),
                        requestDto.author(),
                        requestDto.releaseYear()
                )
        );

        return new BookResponseDto(book);
    }

    @Transactional
    public BookResponseDto updateBook(UpdateBookRequestDto requestDto) {
        if (StringUtil.isNullOrEmpty(requestDto.title())
                && StringUtil.isNullOrEmpty(requestDto.author())
                && requestDto.releaseYear() == null) {
            throw new RuntimeException("No data to update.");
        }

        Book book = bookRepository.findById(requestDto.id())
                .orElseThrow(() -> new RuntimeException("Book not found."));


        if (StringUtil.notNullNorEmpty(requestDto.title())) {
            book.setTitle(requestDto.title());
        }

        if (StringUtil.notNullNorEmpty(requestDto.author())) {
            book.setAuthor(requestDto.author());
        }

        if (requestDto.releaseYear() != null){
            book.setReleaseYear(requestDto.releaseYear());
        }

        return new BookResponseDto(book);
    }
}
