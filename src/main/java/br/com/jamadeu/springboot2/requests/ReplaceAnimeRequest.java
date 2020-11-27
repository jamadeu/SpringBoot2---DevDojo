package br.com.jamadeu.springboot2.requests;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReplaceAnimeRequest {
    @Positive(message = "The anime id cannot be zero or negative")
    @DecimalMin(value = "1", message = "The anime id must be a long")
    @NotNull(message = "The anime id cannot be null")
    private Long id;
    @NotEmpty(message = "The anime name cannot be empty")
    private String name;
}
