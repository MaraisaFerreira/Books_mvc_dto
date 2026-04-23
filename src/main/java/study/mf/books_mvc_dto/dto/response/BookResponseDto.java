package study.mf.books_mvc_dto.dto.response;

import study.mf.books_mvc_dto.entities.Book;

public record BookResponseDto(
        String title,
        String author,
        Integer releaseYear
) {
    public BookResponseDto(Book book) {
        this(
                book.getTitle(),
                book.getAuthor(),
                book.getReleaseYear()
        );
    }
}
