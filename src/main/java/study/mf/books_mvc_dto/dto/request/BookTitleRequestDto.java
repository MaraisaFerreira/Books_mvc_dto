package study.mf.books_mvc_dto.dto.request;

import jakarta.validation.constraints.NotBlank;

public record BookTitleRequestDto(
        @NotBlank(message = "Title cannot be null or empty.") String title
) {
}
