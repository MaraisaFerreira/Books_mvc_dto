package study.mf.books_mvc_dto.dto.request;

import jakarta.validation.constraints.NotBlank;

public record BookTitleAuthorRequestDto(
        @NotBlank(message = "Title cannot be null or empty.") String title,
        @NotBlank(message = "Author cannot be null or empty.") String author
) {
}
