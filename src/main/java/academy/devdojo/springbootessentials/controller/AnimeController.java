package academy.devdojo.springbootessentials.controller;

import academy.devdojo.springbootessentials.domain.Anime;
import academy.devdojo.springbootessentials.requests.AnimePostRequestBody;
import academy.devdojo.springbootessentials.requests.AnimePutRequestBody;
import academy.devdojo.springbootessentials.services.AnimeService;
import academy.devdojo.springbootessentials.util.Date;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("anime")
@Log4j2
@RequiredArgsConstructor
public class AnimeController {

    public final Date date;
    public final AnimeService animeService;

    @GetMapping
    public ResponseEntity<List<Anime>> list() {
        log.info(date.formatLocalDateTimeToDataBaseStyle(LocalDateTime.now()));
        return new ResponseEntity<>(animeService.listAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Anime> findById(@PathVariable long id) {
        return ResponseEntity.ok(animeService.findByIdOrElseThrowExeception(id));
    }

    @GetMapping("/find")
    public ResponseEntity<List<Anime>> findByName(@RequestParam(name = "name") String name) {
        return ResponseEntity.ok(animeService.findByName(name));
    }
    
    @PostMapping
    public ResponseEntity<Anime> save(@RequestBody AnimePostRequestBody animePostRequestBody) {
        return new ResponseEntity<>(animeService.save(animePostRequestBody), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        animeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping()
    public ResponseEntity<Anime> replace(@RequestBody AnimePutRequestBody animePutRequestBody) {
        animeService.replace(animePutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
