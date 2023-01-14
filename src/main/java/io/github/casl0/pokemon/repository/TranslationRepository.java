package io.github.casl0.pokemon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import io.github.casl0.pokemon.entity.Translation;

/**
 * pokemon_translationテーブルのDAO
 */
@Repository
public interface TranslationRepository extends JpaRepository<Translation, String> {
  @Query(
      value = "SELECT * FROM pokemon_translation WHERE jpn = :name OR eng = :name OR "
          + "deu = :name OR fra = :name OR kor = :name OR chs = :name OR cht = :name",
      nativeQuery = true)
  public Translation findByName(@Param("name") String name);
}
