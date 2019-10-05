package io.gitlab.mihajlonesic.springgraphqlmysql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import io.gitlab.mihajlonesic.springgraphqlmysql.entity.Language;
import io.gitlab.mihajlonesic.springgraphqlmysql.service.LanguageService;

import java.util.List;

public class Query implements GraphQLQueryResolver {

    private final LanguageService languageService;

    public Query(LanguageService languageService) {
        this.languageService = languageService;
    }

    public List<Language> allLanguages() {
        return languageService.getAll();
    }

    public Language language(Long id) {
        return languageService.getById(id);
    }

    public List<Language> languageType(String languageType) {
        return languageService.getByLanguageType(languageType);
    }

}
