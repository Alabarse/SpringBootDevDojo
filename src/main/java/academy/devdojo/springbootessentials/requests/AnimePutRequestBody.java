package academy.devdojo.springbootessentials.requests;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class AnimePutRequestBody {
    private Long id;
    private String name;
}
