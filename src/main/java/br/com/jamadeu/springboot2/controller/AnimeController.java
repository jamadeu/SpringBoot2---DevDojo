package br.com.jamadeu.springboot2.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
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
  public List<Anime> list() {
    return animeService.listAll();
  }
}
