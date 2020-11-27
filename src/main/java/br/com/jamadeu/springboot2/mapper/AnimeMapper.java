package br.com.jamadeu.springboot2.mapper;

import br.com.jamadeu.springboot2.domain.Anime;
import br.com.jamadeu.springboot2.requests.NewAnimeRequest;
import br.com.jamadeu.springboot2.requests.ReplaceAnimeRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class AnimeMapper {
    public static final AnimeMapper INSTANCE = Mappers.getMapper(AnimeMapper.class);

    public Anime toAnime(NewAnimeRequest newAnimeRequest) {
        Anime anime = new Anime();
        anime.setName(newAnimeRequest.getName());
        return anime;
    }

    public abstract Anime toAnime(ReplaceAnimeRequest replaceAnimeRequest);
}
