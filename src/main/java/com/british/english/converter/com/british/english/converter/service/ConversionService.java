package com.british.english.converter.com.british.english.converter.service;

import com.british.english.converter.InvalidInputException;

/**
 * Created by Arpitha.V on 15/08/2016.
 * Converts given integer to British English Words representation
 */
public interface ConversionService {

    /**
     * Returns a British English Word Representation of given integer
     * Supports integers in range from 0 to 999999999.
     * @param number
     * @return
     * @throws InvalidInputException
     */
    String getNumberinBritishEnglishWords(Integer number)throws InvalidInputException;
}
