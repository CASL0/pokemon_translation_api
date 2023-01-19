package io.github.casl0.pokemon.service;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponseException;
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
   *
   * @return 翻訳情報のリスト
   */
  public List<TranslationResponse> findAll() {
    return translationRepository.findAll().stream().map(TranslationResponse::of).toList();
  }

  /**
   * ポケモンの名称で検索します
   *
   * @param name ポケモン名
   * @return 検索でHITした翻訳情報
   * @throws ErrorResponseException 検索で見つからなかった場合に400エラーの例外をThrowします
   */
  public TranslationResponse findByName(String name) throws ErrorResponseException {
    try {
      return TranslationResponse.of(translationRepository.findByName(name));
    } catch (Throwable e) {
      throw new ErrorResponseException(HttpStatus.BAD_REQUEST);
    }
  }
}
