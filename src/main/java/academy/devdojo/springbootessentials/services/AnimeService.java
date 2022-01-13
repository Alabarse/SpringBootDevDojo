package academy.devdojo.springbootessentials.services;

import academy.devdojo.springbootessentials.domain.Anime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AnimeService {

    private static List<Anime> animes;

    static {
        animes = new ArrayList(List.of(new Anime("Boku no Hero", 1L), new Anime("Naruto", 2L)));
    }

    public List<Anime> listAll() {
        return animes;
    }

    public Anime findById(long id) {
        return animes.stream().filter(anime -> anime.getId().equals(id)).findFirst().orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not found, check the ID"));
    }

    public Anime save(Anime anime) {
        anime.setId(ThreadLocalRandom.current().nextLong(3, 1000));
        animes.add(anime);
        return anime;
    }

    public void delete(Long id) {
        animes.remove(findById(id));
    }
}
