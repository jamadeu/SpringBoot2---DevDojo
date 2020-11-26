package br.com.jamadeu.springboot2.util;

import br.com.jamadeu.springboot2.requests.NewAnimeRequest;

public class NewAnimeRequestCreator {
    public static NewAnimeRequest createNewAnimeRequest() {
        return NewAnimeRequest.builder()
                .name(AnimeCreator.createAnimeToBeSaved().getName())
                .build();
    }
}
