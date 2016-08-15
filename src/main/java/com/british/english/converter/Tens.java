package com.british.english.converter;

/**
 * Created by Arpitha.V on 15/08/2016.
 * Enum with word representation of numbers 10,20,30,40,50,60,70,80,90
 */
public enum Tens {
    TEN("Ten"),
    TWENTY("Twenty"),
    THIRTY("Thirty"),
    FOURTY("Forty"),
    FIFTY("Fifty"),
    SIXTY("Sixty"),
    SEVENTY("Seventy"),
    EIGHTY("Eighty"),
    NINETY("Ninety");

    private String inWord;

    private Tens(String word)
    {
        this.inWord = word;
    }
    public String getWord()
    {
        return this.inWord;
    }
}
