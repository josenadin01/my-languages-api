package com.api.languages.api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.api.languages.api.model.Language;
import com.api.languages.api.repository.LanguageRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class LanguageController {

    @Autowired
    private LanguageRepository languageRepo;

    @GetMapping("/languages")
    public List<Language> getLanguages() {
        List<Language> languages = languageRepo.findAll();
        return languages;
    }

    @GetMapping("/languages/ranking")
    public List<Language> getRankedList() {
        List<Language> rankedList = languageRepo.findAll(Sort.by("ranking"));
        return rankedList;
    }

    @PostMapping("/languages")
    public Language newLanguage(@RequestBody Language language) {
        Language savedLanguage = languageRepo.save(language);
        return savedLanguage;
    }

    @PutMapping("/languages/{id}")
    public ResponseEntity<Language> updateLanguage(@PathVariable String id, @RequestBody Language language) {
        Language newLanguage = languageRepo.findById(id).orElseThrow();
        newLanguage.setTitle(language.getTitle());
        newLanguage.setImage(language.getImage());
        newLanguage.setRanking(language.getRanking());
        languageRepo.save(newLanguage);
        return ResponseEntity.ok(newLanguage);
    }

    @DeleteMapping("languages/{id}")
    public String deleteLanguage(@PathVariable String id) {
        try {
            languageRepo.deleteById(id);
            return "Apagado com sucesso";
        } catch (Exception e) {
            return "Id não encontrado";
        }

    }
}
