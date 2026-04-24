package study.mf.books_mvc_dto.dto.response;

public record ExceptionResponseDto(
        Long timestamp,
        String message,
        String details
) {
}
