package br.com.jamadeu.springboot2.requests;

import br.com.jamadeu.springboot2.domain.Anime;
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
    private String name;

    public Anime toAnime() {
        Anime anime = new Anime();
        anime.setName(this.name);
        return anime;
    }
}
