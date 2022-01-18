package academy.devdojo.springbootessentials.exception;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
@AllArgsConstructor
public class BadRequestExceptionDetails {
    private String title;
    private int Status;
    private String details;
    private String developerMessage;
    private LocalDateTime timestamp;
}
