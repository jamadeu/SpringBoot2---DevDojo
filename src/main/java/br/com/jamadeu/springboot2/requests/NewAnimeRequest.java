package br.com.jamadeu.springboot2.requests;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class NewAnimeRequest {
  @NotEmpty(message = "The anime name cannot be empty")
  private String name;
}
