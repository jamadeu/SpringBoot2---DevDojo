package br.com.jamadeu.springboot2.repository;

import java.util.List;

import br.com.jamadeu.springboot2.domain.Anime;

public interface AnimeRepository {
  List<Anime> listAll();
}
