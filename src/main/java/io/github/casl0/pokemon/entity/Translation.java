package io.github.casl0.pokemon.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * pokemon_translationテーブルのエンティティ
 */
@Entity
@Data
@Table(name = "pokemon_translation")
public class Translation {
  /**
   * 番号
   */
  @Column(nullable = true, length = 10)
  private String id;

  /**
   * 日本語
   */
  @Nonnull
  @Column(nullable = false, length = 10)
  private String jpn;

  /**
   * 英語
   */
  @Id
  @Nonnull
  @Column(nullable = false,length = 100)
  private String eng;

  /**
   * ドイツ語
   */
  @Nonnull
  @Column(nullable = false, length = 20)
  private String deu;

  /**
   * フランス語
   */
  @Nonnull
  @Column(nullable = false, length = 20)
  private String fra;

  /**
   * 韓国語
   */
  @Nonnull
  @Column(nullable = false, length = 10)
  private String kor;

  /**
   * 中国語（簡）
   */
  @Nonnull
  @Column(nullable = false, length = 10)
  private String chs;

  /**
   * 中国語（繁）
   */
  @Nonnull
  @Column(nullable = false, length = 10)
  private String cht;
}
