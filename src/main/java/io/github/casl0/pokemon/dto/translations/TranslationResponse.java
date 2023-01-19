package io.github.casl0.pokemon.dto.translations;

import com.fasterxml.jackson.annotation.JsonFilter;
import io.github.casl0.pokemon.entity.Translation;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * translationsのレスポンス
 */
@Data
@AllArgsConstructor
@JsonFilter("TranslationResponseFilter")
public class TranslationResponse {
  /**
   * 番号
   */
  private String id;

  /**
   * 日本語
   */
  private String jpn;

  /**
   * 英語
   */
  private String eng;

  /**
   * ドイツ語
   */
  private String deu;

  /**
   * フランス語
   */
  private String fra;

  /**
   * 韓国語
   */
  private String kor;

  /**
   * 中国語（簡）
   */
  private String chs;

  /**
   * 中国語（繁）
   */
  private String cht;

  /**
   * EntityからDTOへ変換します
   *
   * @param translation translationのEntity
   * @return translationのDTO
   */
  public static TranslationResponse of(Translation translation) {
    return new TranslationResponse(translation.getId(), translation.getJpn(), translation.getEng(),
        translation.getDeu(), translation.getFra(), translation.getKor(), translation.getChs(),
        translation.getCht());
  }
}
