package br.com.jamadeu.springboot2.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.jamadeu.springboot2.domain.Anime;
import br.com.jamadeu.springboot2.requests.NewAnimeRequest;
import br.com.jamadeu.springboot2.requests.ReplaceAnimeRequest;

@Mapper(componentModel = "spring")
public abstract class AnimeMapper {
  public static final AnimeMapper INSTANCE = Mappers.getMapper(AnimeMapper.class);

  public abstract Anime toAnime(NewAnimeRequest newAnimeRequest);

  public abstract Anime toAnime(ReplaceAnimeRequest replaceAnimeRequest);
}
