package academy.devdojo.springbootessentials.requests;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AnimePostRequestBody {

    @NotEmpty(message = "Anime name cannot be empty")
    @NotNull(message = "Anime name cannot be null")
    private String name;
}
