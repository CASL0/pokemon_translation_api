package io.github.casl0.pokemon.controller;

import java.util.Optional;
import java.util.Set;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
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

  private final static Set<String> LANGUAGES =
      Set.of("jpn", "eng", "deu", "fra", "kor", "chs", "cht");

  /**
   * 翻訳情報を全件返します
   *
   * @return
   */
  @GetMapping
  public MappingJacksonValue findAll() {
    final FilterProvider filters = new SimpleFilterProvider().addFilter("TranslationResponseFilter",
        SimpleBeanPropertyFilter.serializeAll());
    final var mapping = new MappingJacksonValue(translationService.findAll());
    mapping.setFilters(filters);
    return mapping;
  }

  /**
   * ポケモン名で検索し、HITした翻訳情報を返します
   *
   * @param name ポケモン名
   * @param language 取得したい言語
   * @return 検索でHITした翻訳情報
   */
  @GetMapping(path = "{name}")
  public MappingJacksonValue findByName(@PathVariable("name") String name,
      @RequestParam(required = false, value = "language") Optional<Set<String>> language) {
    final var includedLanguages = language.orElse(LANGUAGES);

    final FilterProvider filters = new SimpleFilterProvider().addFilter("TranslationResponseFilter",
        SimpleBeanPropertyFilter.filterOutAllExcept(includedLanguages));
    final var mapping = new MappingJacksonValue(translationService.findByName(name));
    mapping.setFilters(filters);
    return mapping;
  }
}
