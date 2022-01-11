package academy.devdojo.springboot.controller;

import academy.devdojo.springboot.domain.Anime;
import academy.devdojo.springboot.util.DateUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("anime")
public class AnimeController {
    
    @Autowired
    private DateUtil date;
    
    @GetMapping("list")
    public List<Anime> list() {
        return List.of(new Anime("Boku no Hero"), new Anime("Naruto"));
    }
}
