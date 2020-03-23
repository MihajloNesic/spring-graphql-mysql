package io.gitlab.mihajlonesic.springgraphqlmysql.service;

import io.gitlab.mihajlonesic.springgraphqlmysql.entity.Language;
import io.gitlab.mihajlonesic.springgraphqlmysql.exception.LanguageException;
import io.gitlab.mihajlonesic.springgraphqlmysql.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LanguageService {

    @Autowired
    private LanguageRepository languageRepository;

    public List<Language> getAll() {
        return languageRepository.findAll();
    }

    public Language getById(Long id) {
        Optional<Language> language = languageRepository.findById(id);
        if (!language.isPresent()) {
            throw new LanguageException(404, "Language with id " + id + " cannot be found");
        }
        return language.get();
    }

    public List<Language> getByLanguageType(String languageType) {
        return languageRepository.findByLanguageType(languageType);
    }

    public Language create(String name, String code, String color, String languageType) {
        Language language = Language.create(name, code, color, languageType);
        return languageRepository.save(language);
    }

    public Language update(Long id, String name, String code, String color, String languageType) {
        Language language = getById(id);
        language.updateFields(name, code, color, languageType);
        return languageRepository.save(language);
    }

    public boolean delete(Long id) {
        Language language = getById(id);
        languageRepository.delete(language);
        return true;
    }
}
