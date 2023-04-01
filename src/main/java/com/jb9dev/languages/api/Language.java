package com.jb9dev.languages.api;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.annotation.Documented;

@Document(collection = "favoriteLanguages")
public class Language {
    @Id
    private String id;
    private String image;
    private String title;
    private int ranking;

    public Language(String title, String image, int ranking) {
        this.image = image;
        this.title = title;
        this.ranking = ranking;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public int getRanking() {
        return ranking;
    }

}
