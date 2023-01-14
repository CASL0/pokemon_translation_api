package io.github.casl0.pokemon.dto.translations;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * translations 全件取得のレスポンス
 */
@Data
@AllArgsConstructor
public class TranslationAllResponse {
  private List<TranslationResponse> translations;
}
