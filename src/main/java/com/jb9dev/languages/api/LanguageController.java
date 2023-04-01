package com.jb9dev.languages.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

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
    public List<Language> listLanguagesRanking() {
        // TODO: Sort by ranking
        return repository.findAll();
    }

    @GetMapping("/languages-ranking/{id}")
    public Language getLanguageById(@PathVariable String id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/languages-ranking")
    public ResponseEntity<Language> addLanguageOnRanking(@RequestBody Language language) {
        // Find how to return status 201
        return new ResponseEntity<>(repository.save(language), HttpStatus.CREATED);
    }

    @PutMapping("/languages-ranking/{id}")
    public Language updateLanguageOnRanking(@PathVariable String id, @RequestBody Language language) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        System.out.println("language: " + language);

        language.setId(id);
        return repository.save(language);
    }

    @DeleteMapping("/languages-ranking/{id}")
    public void deleteLanguageFromRanking(@PathVariable String id) {
        if(!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        repository.deleteById(id);
    }
}
