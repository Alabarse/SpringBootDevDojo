package academy.devdojo.springbootessentials.handler;

import academy.devdojo.springbootessentials.exception.BadRequestException;
import academy.devdojo.springbootessentials.exception.BadRequestExceptionDetails;
import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<BadRequestExceptionDetails> handlerBadRequestException(BadRequestException bre) {
        return new ResponseEntity<>(
                BadRequestExceptionDetails.builder()
                        .timestamp(LocalDateTime.now())
                        .Status(HttpStatus.BAD_REQUEST.value())
                        .title("BAD REQUEST EXCEPTION, check the documentation")
                        .details("AnimeNotFound")
                        .developerMessage(bre.getClass().getName())
                        .build(), HttpStatus.BAD_REQUEST);
    }
}
