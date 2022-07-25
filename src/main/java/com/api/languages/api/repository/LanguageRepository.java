package com.api.languages.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.api.languages.api.model.Language;

public interface LanguageRepository extends MongoRepository<Language, String> {
    
}