package br.com.jamadeu.springboot2.util;

import br.com.jamadeu.springboot2.domain.Anime;

public class AnimeCreator {

    public static Anime createAnimeToBeSaved() {
        return Anime.builder()
                .name("Hellsing")
                .build();
    }

    public static Anime createValidAnime() {
        return Anime.builder()
                .id(1L)
                .name("Hellsing")
                .build();
    }

    public static Anime createValidUpdatedAnime() {
        return Anime.builder()
                .id(1L)
                .name("Hellsing 2")
                .build();
    }


}
