package academy.devdojo.springboot.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;

@Component
public class DateUtil {
    public String formatLocalDateTimeToDataBaseStyle(LocalDateTime lcdt) {
        return DateTimeFormatter.ofPattern("yy-MM-dd HH:mm:ss").format(lcdt);
    }
}
