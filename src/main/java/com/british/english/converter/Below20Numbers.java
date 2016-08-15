package com.british.english.converter;

/**
 * Created by Arpitha.V on 15/08/2016.
 * Enum with word representation of numbers from 0-19
 */
public enum Below20Numbers {

    ZERO("Zero"),
    ONE("One"),
    TWO("Two"),
    THREE("Three"),
    FOUR("Four"),
    FIVE("Five"),
    SIX("Six"),
    SEVEN("Seven"),
    EIGHT("Eight"),
    NINE("Nine"),
    TEN("Ten"),
    ELEVEN("Eleven"),
    TWELVE("Twelve"),
    THIRTEEN("Thirteen"),
    FOURTEEN("Fourteen"),
    FIFTEEN("Fifteen"),
    SIXTEEN("Sixteen"),
    SEVENTEEN("Seventeen"),
    EIGHTEEN("Eighteen"),
    NINETEEN("Nineteen");

    private String inWord;

    private Below20Numbers(String word)
    {
        this.inWord = word;
    }
    public String getWord()
    {
        return this.inWord;
    }
}
