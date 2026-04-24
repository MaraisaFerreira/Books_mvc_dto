package study.mf.books_mvc_dto.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AddBookRequestDto(
        @NotBlank(message = "The field title cannot be null or empty.") String title,
        @NotBlank(message = "The field author cannot be null or empty.") String author,
        @NotNull(message = "The field releaseYear cannot be null.") Integer releaseYear
) {
}
