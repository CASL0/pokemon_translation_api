package io.github.casl0.pokemon.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.github.casl0.pokemon.dto.translations.TranslationAllResponse;
import io.github.casl0.pokemon.service.TranslationService;
import jakarta.annotation.Nonnull;
import lombok.RequiredArgsConstructor;

/**
 * 翻訳情報関連コントローラー
 */
@RestController
@RequestMapping(path = "/v1/translations")
@RequiredArgsConstructor
public class TranslationController {
  @Nonnull
  private final TranslationService translationService;

  @GetMapping
  public TranslationAllResponse findAll() {
    return translationService.findAll();
  }
}
