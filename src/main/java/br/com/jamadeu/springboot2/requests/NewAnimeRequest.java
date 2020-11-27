package br.com.jamadeu.springboot2.requests;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NewAnimeRequest {
    @NotEmpty(message = "The anime name cannot be empty")
    private String name;
}
