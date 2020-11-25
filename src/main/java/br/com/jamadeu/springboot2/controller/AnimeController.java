package br.com.jamadeu.springboot2.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jamadeu.springboot2.domain.Anime;
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
    return new ResponseEntity<>(animeService.findById(id), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<Anime> save(@RequestBody Anime anime){
    return new ResponseEntity<>(animeService.save(anime), HttpStatus.CREATED);
  }
}
