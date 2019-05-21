package com.example.kanjilearn;

public class Card {

    private String Kana;
    private String KanaRead;
    private String KanaTTS;

    public Card (){
    }

    public Card (String kana, String kanaRead, String kanaTTS){
        Kana = kana;
        KanaRead = kanaRead;
        KanaTTS = kanaTTS;
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

    public void setKanaTTS(String kanaTTS) {
        KanaTTS = kanaTTS;
    }

    public String getKanaTTS() {
        return KanaTTS;
    }
}
