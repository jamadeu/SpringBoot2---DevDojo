package br.com.jamadeu.springboot2.util;

import br.com.jamadeu.springboot2.requests.ReplaceAnimeRequest;

public class ReplaceAnimeRequestCreator {
    public static ReplaceAnimeRequest createReplaceAnimeRequest() {
        return ReplaceAnimeRequest.builder()
                .name(AnimeCreator.createValidUpdatedAnime().getName())
                .id(AnimeCreator.createValidUpdatedAnime().getId())
                .build();
    }
}
