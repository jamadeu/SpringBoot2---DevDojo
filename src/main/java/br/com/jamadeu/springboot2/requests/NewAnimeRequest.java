package br.com.jamadeu.springboot2.requests;

import javax.validation.constraints.NotEmpty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NewAnimeRequest {
    @NotEmpty(message = "The anime name cannot be empty")
    private String name;
}
