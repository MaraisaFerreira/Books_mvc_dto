package study.mf.books_mvc_dto.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import study.mf.books_mvc_dto.dto.response.ExceptionResponseDto;

import java.time.Instant;

@RestControllerAdvice
public class CustomExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponseDto> genericException(Exception ex, WebRequest request){
        return ResponseEntity.internalServerError().body(new ExceptionResponseDto(
                Instant.now().toEpochMilli(),
                ex.getMessage(),
                request.getDescription(false)
        ));
    }

    @ExceptionHandler(CustomBadRequestException.class)
    public ResponseEntity<ExceptionResponseDto> badRequestException(CustomBadRequestException ex, WebRequest request){
        return ResponseEntity.badRequest().body(new ExceptionResponseDto(
                Instant.now().toEpochMilli(),
                ex.getMessage(),
                request.getDescription(false)
        ));
    }

    @ExceptionHandler(CustomNotFoundException.class)
    public ResponseEntity<ExceptionResponseDto> genericException(CustomNotFoundException ex, WebRequest request){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionResponseDto(
                Instant.now().toEpochMilli(),
                ex.getMessage(),
                request.getDescription(false)
        ));
    }
}
