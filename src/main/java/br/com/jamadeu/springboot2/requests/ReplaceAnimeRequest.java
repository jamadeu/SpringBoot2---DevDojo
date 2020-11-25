package br.com.jamadeu.springboot2.requests;

import lombok.Data;

@Data
public class ReplaceAnimeRequest {
  private Long id;
  private String name;
}
