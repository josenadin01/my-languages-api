package com.api.languages.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "topLanguages")
public class Language {

    @Id
    private String id;

    private String title;

    private String image;

    private int ranking;

}