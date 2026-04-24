package study.mf.books_mvc_dto.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import study.mf.books_mvc_dto.dto.request.AddBookRequestDto;
import study.mf.books_mvc_dto.dto.request.BookTitleAuthorRequestDto;
import study.mf.books_mvc_dto.dto.request.BookTitleRequestDto;
import study.mf.books_mvc_dto.dto.request.UpdateBookRequestDto;
import study.mf.books_mvc_dto.dto.response.BookResponseDto;
import study.mf.books_mvc_dto.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/search_all")
    public ResponseEntity<List<BookResponseDto>> findAll(){
        return ResponseEntity.ok(bookService.findAll());
    }

    @PostMapping("/search_title")
    public ResponseEntity<List<BookResponseDto>> findByTitle(@Valid @RequestBody BookTitleRequestDto requestDto){
        return ResponseEntity.ok(bookService.findByTitle(requestDto.title()));
    }

    @PostMapping("/search_title_and_author")
    public ResponseEntity<BookResponseDto> findByTitleAndAuthor(@Valid @RequestBody BookTitleAuthorRequestDto requestDto){
        return ResponseEntity.ok(bookService.findByTitleAndAuthor(requestDto.title(), requestDto.author()));
    }

    @PostMapping("/add_book")
    public ResponseEntity<BookResponseDto> saveBook(@Valid @RequestBody AddBookRequestDto requestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.saveBook(requestDto));
    }

    @PutMapping("/update_book")
    public ResponseEntity<BookResponseDto> updateBook(@Valid @RequestBody UpdateBookRequestDto requestDto){
        return ResponseEntity.ok(bookService.updateBook(requestDto));
    }
}
