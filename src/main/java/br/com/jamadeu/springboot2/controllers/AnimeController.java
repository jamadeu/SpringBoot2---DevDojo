package br.com.jamadeu.springboot2.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jamadeu.springboot2.domain.Anime;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("anime")
@RequiredArgsConstructor
public class AnimeController {

  @GetMapping
  public List<Anime> list() {
    return List.of(new Anime("BDZ"), new Anime("Berserk"));
  }
}
