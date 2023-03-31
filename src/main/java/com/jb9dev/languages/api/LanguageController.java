package com.jb9dev.languages.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@RestController
public class LanguageController {

    @Autowired
    private LanguageRepository repository;

    @GetMapping("/favorite-language")
    public Language getFavoriteLanguage() {
        // TODO: Find a best way to get the first in raking
        List<Language> languagesRaking = repository.findAll();
        Language firstLanguageInRaking = null;

        for (Language language : languagesRaking) {
            if (language.getRanking() == 1) {
                firstLanguageInRaking = language;
            }
        }
        return firstLanguageInRaking;
    }

    @GetMapping("/languages-ranking")
    public List<Language> getLanguagesRaking() {
        return repository.findAll();
    }

    @PostMapping("/languages-ranking")
    public Language create(@RequestBody Language language) {
        // Find how to return status 201
        return repository.save(language);
    }
}
