package academy.devdojo.springbootessentials.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;

@Component
public class Date {
    public String formatLocalDateTimeToDataBaseStyle(LocalDateTime LocalDateTime) {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime);
    }
}
