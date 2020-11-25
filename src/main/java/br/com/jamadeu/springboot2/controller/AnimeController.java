package br.com.jamadeu.springboot2.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jamadeu.springboot2.domain.Anime;
import br.com.jamadeu.springboot2.requests.NewAnimeRequest;
import br.com.jamadeu.springboot2.requests.ReplaceAnimeRequest;
import br.com.jamadeu.springboot2.service.AnimeService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("animes")
@RequiredArgsConstructor
public class AnimeController {
  private final AnimeService animeService;

  @GetMapping
  public ResponseEntity<List<Anime>> list() {
    return new ResponseEntity<>(animeService.listAll(), HttpStatus.OK);
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<Anime> findById(@PathVariable long id) {
    return new ResponseEntity<>(animeService.findByIdOrThrowBadRequestException(id), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<Anime> save(@RequestBody NewAnimeRequest newAnimeRequest) {
    return new ResponseEntity<>(animeService.save(newAnimeRequest), HttpStatus.CREATED);
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity<Anime> delete(@PathVariable long id) {
    animeService.delete(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @PutMapping
  public ResponseEntity<Anime> replace(@RequestBody ReplaceAnimeRequest replaceAnimeRequest) {
    animeService.replace(replaceAnimeRequest);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
