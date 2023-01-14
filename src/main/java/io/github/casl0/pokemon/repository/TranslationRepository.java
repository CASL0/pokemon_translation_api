package io.github.casl0.pokemon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import io.github.casl0.pokemon.entity.Translation;

/**
 * pokemon_translationテーブルのDAO
 */
@Repository
public interface TranslationRepository extends JpaRepository<Translation, String> {
}
