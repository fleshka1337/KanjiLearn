package com.example.kanjilearn;

import java.util.ArrayList;

public class SingleRow {

    String title;
    String description;
    int image;
    String kanji;

    public String getKanji() {
        return kanji;
    }

    public void setKanji(String kanji) {
        this.kanji = kanji;
    }

    public SingleRow(String title, String description, int image, String kanji){
        this.title = title;
        this.description = description;
        this.image = image;
        this.kanji = kanji;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }


}
