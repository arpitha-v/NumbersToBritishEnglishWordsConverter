package com.british.english.converter.com.british.english.converter.service.impl;

import com.british.english.converter.WordConstants;
import com.british.english.converter.InvalidInputException;
import com.british.english.converter.Below20Numbers;
import com.british.english.converter.Tens;
import com.british.english.converter.com.british.english.converter.service.ConversionService;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Arpitha.V on 15/08/2016.
 * Converts given integer to British English Words representation
 */
public class ConversionServiceImpl implements ConversionService {

    private static final List<Below20Numbers> words = Arrays.asList(Below20Numbers.values());
    private static final List<Tens> tens = Arrays.asList(Tens.values());
    private static final Integer MIN = 0;
    private static final Integer MAX = 1000000000;

    /**
     * Returns a british english word representation of integers in range from 0-999999999.
     * @param number the number to be converted
     * @return returns british english word for the given Number
     * @throws InvalidInputException
     */
    public String getNumberinBritishEnglishWords(final Integer number) throws InvalidInputException {

        if (number != null && number >= MIN && number < MAX) {
            if (number.equals(MIN)) {
                return words.get(0).getWord();
            }
            return convertNumberInMillions(number);
        } else if (number == null) {
            throw new InvalidInputException("The input is null");
        } else if (number >= MAX) {
            throw new InvalidInputException("The input should be less than 1000000000");
        } else {
            throw new InvalidInputException("The input provided is invalid. Should be between 0-999999999");
        }
    }

    /**
     * Returns a british english word representation of integers in range from 0-999999999.
     * @param number the number to be converted
     * @return returns british english word for the given Number
     */
    private String convertNumberInMillions(Integer number) {
        if (number < 1000000) {
            return convertNumberBelow1000000(number);
        } else {
            Integer modulus = number % 1000000;
            Integer quotient = number / 1000000;
            String inWords = convertNumberBelow1000000(quotient) + WordConstants.SPACE + WordConstants.MILLION;

            if (modulus == 0) {
                return inWords;
            } else {
                if (modulus < 100)
                    return inWords + WordConstants.AND + convertNumberBelow1000000(modulus);
                else
                    return inWords + WordConstants.SPACE + convertNumberBelow1000000(modulus);
            }

        }
    }

    /**
     * Returns a british english word representation of integers in range from 0-999999.
     *
     * @param number the number to be converted
     * @return returns british english word for the given Number
     */

    private String convertNumberBelow1000000(Integer number) {
        if (number < 1000) {
            return convertNumberBelow1000(number);
        } else {
            Integer modulus = number % 1000;
            Integer quotient = number / 1000;
            String inWords = convertNumberBelow1000(quotient) + WordConstants.SPACE + WordConstants.THOUSAND;
            if (modulus == 0) {
                return inWords;
            } else {
                if (modulus < 100)
                    return inWords + WordConstants.AND + convertNumberBelow1000(modulus);
                else
                    return inWords + WordConstants.SPACE + convertNumberBelow1000(modulus);
            }
        }
    }

    /**
     * Returns a british english word representation of integers in range from 0-999.
     * @param number the number to be converted
     * @return returns british english word for the given Number
     */
    private String convertNumberBelow1000(Integer number) {
        if (number < 100) {
            return convertNumberBelow100(number);
        } else {
            Integer modulus = number % 100;
            Integer quotient = number / 100;
            String inWords = words.get(quotient).getWord() + WordConstants.SPACE + WordConstants.HUNDREAD;
            if (modulus == 0) {
                return inWords;
            } else {
                return inWords + WordConstants.AND + convertNumberBelow100(modulus);
            }
        }
    }

    /**
     * Returns a british english word representation of integers in range from 0-99.
     * @param number the number to be converted
     * @return returns british english word for the given Number
     */
    private String convertNumberBelow100(Integer number) {
        if (number < 20) {
            return words.get(number).getWord();
        }
        Integer modulus = number % 10;
        String inWords = tens.get(number / 10 - 1).getWord();
        if (modulus == 0) {
            return inWords;
        } else {
            return inWords + WordConstants.SPACE + words.get(modulus).getWord();
        }
    }
}
