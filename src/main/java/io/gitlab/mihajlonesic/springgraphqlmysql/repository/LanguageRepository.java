package io.gitlab.mihajlonesic.springgraphqlmysql.repository;

import io.gitlab.mihajlonesic.springgraphqlmysql.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LanguageRepository extends JpaRepository<Language, Long> {

    @Query("select l from Language l, LanguageType lt where l.languageType.id = lt.id and lt.type = upper(:languageType)")
    List<Language> findByLanguageType(@Param("languageType") String languageType);
}
