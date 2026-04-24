package study.mf.books_mvc_dto.dto.request;

import jakarta.validation.constraints.NotNull;

public record UpdateBookRequestDto(
        @NotNull(message = "The filed id cannot be null.") Long id,
        String title,
        String author,
        Integer releaseYear
) {
}
