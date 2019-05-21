package com.example.kanjilearn;

public class Card {

    private String Kana;
    private String KanaRead;

    public Card (){

    }

    public Card (String kana, String kanaRead){
        Kana = kana;
        KanaRead = kanaRead;
    }

    public String getKana() {
        return Kana;
    }

    public String getKanaRead() {
        return KanaRead;
    }

    public void setKana(String kana) {
        Kana = kana;
    }

    public void setKanaRead(String kanaRead) {
        KanaRead = kanaRead;
    }
}
