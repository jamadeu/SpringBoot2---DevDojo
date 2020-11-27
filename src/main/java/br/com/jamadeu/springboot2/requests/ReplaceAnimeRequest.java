package br.com.jamadeu.springboot2.requests;

import br.com.jamadeu.springboot2.domain.Anime;
import br.com.jamadeu.springboot2.exception.BadRequestException;
import br.com.jamadeu.springboot2.repository.AnimeRepository;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReplaceAnimeRequest {


    @Positive(message = "The anime id cannot be zero or negative")
    @DecimalMin(value = "1", message = "The anime id must be a long")
    @NotNull(message = "The anime id cannot be null")
    @Schema(description = "This is the anime's ud", required = true)
    private Long id;
    @NotEmpty(message = "The anime name cannot be empty")
    @Schema(description = "This is the anime's name", example = "Bleach", required = true)
    private String name;


    public Anime toAnime(@NotNull AnimeRepository animeRepository) {
        Anime animeToBeReplaced = animeRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Anime not found"));
        animeToBeReplaced.setName(this.name);
        return animeToBeReplaced;
    }
}
