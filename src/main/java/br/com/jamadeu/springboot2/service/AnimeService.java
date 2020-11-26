package br.com.jamadeu.springboot2.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.jamadeu.springboot2.domain.Anime;
import br.com.jamadeu.springboot2.exception.BadRequestException;
import br.com.jamadeu.springboot2.mapper.AnimeMapper;
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

  public List<Anime> findByName(String name) {
    return animeRepository.findByName(name);
  }

  public Anime findByIdOrThrowBadRequestException(long id) {
    return animeRepository.findById(id).orElseThrow(() -> new BadRequestException("Anime not found"));
  }

  @Transactional
  public Anime save(NewAnimeRequest newAnimeRequest) {
    return animeRepository.save(AnimeMapper.INSTANCE.toAnime(newAnimeRequest));
  }

  public void delete(long id) {
    animeRepository.delete(findByIdOrThrowBadRequestException(id));
  }

  @Transactional
  public void replace(ReplaceAnimeRequest replaceAnimeRequest) {
    Anime savedAnime = findByIdOrThrowBadRequestException(replaceAnimeRequest.getId());
    Anime anime = AnimeMapper.INSTANCE.toAnime(replaceAnimeRequest);
    anime.setId(savedAnime.getId());
    animeRepository.save(anime);
  }
}
