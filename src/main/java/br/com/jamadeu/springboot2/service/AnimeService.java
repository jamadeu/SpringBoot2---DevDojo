package br.com.jamadeu.springboot2.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.jamadeu.springboot2.domain.Anime;
import br.com.jamadeu.springboot2.repository.AnimeRepository;
import br.com.jamadeu.springboot2.requests.NewAnimeRequest;
import br.com.jamadeu.springboot2.requests.ReplaceAnimeRequest;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AnimeService {

  private final AnimeRepository animeRepository;

  public List<Anime> listAll() {
    return animeRepository.findAll();
  }

  public Anime findByIdOrThrowBadRequestException(long id) {
    return animeRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not found"));
  }

  public Anime save(NewAnimeRequest newAnimeRequest) {
    return animeRepository.save(Anime.builder().name(newAnimeRequest.getName()).build());
  }

  public void delete(long id) {
    animeRepository.delete(findByIdOrThrowBadRequestException(id));
  }

  public void replace(ReplaceAnimeRequest replaceAnimeRequest) {
    Anime savedAnime = findByIdOrThrowBadRequestException(replaceAnimeRequest.getId());
    Anime anime = Anime.builder().id(savedAnime.getId()).name(replaceAnimeRequest.getName()).build();

    animeRepository.save(anime);
  }
}
