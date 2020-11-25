package br.com.jamadeu.springboot2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.jamadeu.springboot2.domain.Anime;

@Service
public class AnimeService {
  public List<Anime> listAll() {
    return List.of(new Anime(1L, "BDZ"), new Anime(2L, "Berserk"));
  }
}
