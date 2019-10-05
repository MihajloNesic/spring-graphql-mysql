package io.gitlab.mihajlonesic.springgraphqlmysql.service;

import io.gitlab.mihajlonesic.springgraphqlmysql.entity.Language;
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
            throw new RuntimeException("Language with id " + id + " cannot be found");
        }
        return language.get();
    }

    public List<Language> getByLanguageType(String languageType) {
        return languageRepository.findByLanguageType(languageType);
    }
}
