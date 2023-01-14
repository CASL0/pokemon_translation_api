package io.github.casl0.pokemon.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.github.casl0.pokemon.dto.translations.TranslationAllResponse;
import io.github.casl0.pokemon.dto.translations.TranslationResponse;
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

  /**
   * 翻訳情報を全件返します
   *
   * @return
   */
  @GetMapping
  public TranslationAllResponse findAll() {
    return translationService.findAll();
  }

  /**
   * ポケモン名で検索し、HITした翻訳情報を返します
   *
   * @param name ポケモン名
   * @return 検索でHITした翻訳情報
   */
  @GetMapping(path = "{name}")
  public TranslationResponse findByName(@PathVariable("name") String name) {
    return translationService.findByName(name);
  }
}
