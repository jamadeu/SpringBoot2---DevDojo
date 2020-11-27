package br.com.jamadeu.springboot2.requests;

import br.com.jamadeu.springboot2.domain.Anime;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NewAnimeRequest {
    @NotEmpty(message = "The anime name cannot be empty")
    @Schema(description = "This is the anime's name", example = "Bleach", required = true)
    private String name;

    public Anime toAnime() {
        Anime anime = new Anime();
        anime.setName(this.name);
        return anime;
    }
}
