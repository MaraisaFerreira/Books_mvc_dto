package study.mf.books_mvc_dto.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    @GetMapping
    public ResponseEntity<List<BookResponseDto>> findAll(){
        return ResponseEntity.ok(bookService.findAll());
    }
}
