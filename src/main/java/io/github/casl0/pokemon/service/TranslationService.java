package io.github.casl0.pokemon.service;

import java.util.List;
import org.springframework.stereotype.Service;
import io.github.casl0.pokemon.dto.translations.TranslationAllResponse;
import io.github.casl0.pokemon.dto.translations.TranslationResponse;
import io.github.casl0.pokemon.repository.TranslationRepository;
import jakarta.annotation.Nonnull;
import lombok.RequiredArgsConstructor;

/**
 * 翻訳関連のビジネスロジックを扱うサービス
 */
@Service
@RequiredArgsConstructor
public class TranslationService {
  @Nonnull
  private final TranslationRepository translationRepository;

  /**
   * 全ての翻訳情報を取得します
   * @return 翻訳情報のリスト
   */
  public TranslationAllResponse findAll() {
    final List<TranslationResponse> res =
        translationRepository.findAll().stream().map(TranslationResponse::of).toList();
    return new TranslationAllResponse(res);
  }
}
