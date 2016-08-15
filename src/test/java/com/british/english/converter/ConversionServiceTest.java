package com.british.english.converter;

import com.british.english.converter.com.british.english.converter.service.ConversionService;
import com.british.english.converter.com.british.english.converter.service.impl.ConversionServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Arpitha.V on 15/08/2016.
 * Unit tets which tests Conversion Service.
 */
public class ConversionServiceTest {

    private ConversionService conversionService;

    @Before
    public void setUp()
    {
        conversionService = new ConversionServiceImpl();
    }

    @Test(expected = InvalidInputException.class)
    public void testConvertToBritishEnglishInvalidInput() throws InvalidInputException
    {
        conversionService.getNumberinBritishEnglishWords(null);
    }

    @Test(expected = InvalidInputException.class)
    public void testConvertToBritishEnglishInvalidNegativeInput() throws InvalidInputException
    {
        conversionService.getNumberinBritishEnglishWords(-2);
    }

    @Test(expected = InvalidInputException.class)
    public void testConvertToBritishEnglishInvalidGreaterThanMaxInput() throws InvalidInputException
    {
        conversionService.getNumberinBritishEnglishWords(2000000000);
        conversionService.getNumberinBritishEnglishWords(1000000000);
    }


    @Test
    public void testConvertToBritishEnglishWordsOneDigit() throws InvalidInputException
    {
        assertEquals("Zero", conversionService.getNumberinBritishEnglishWords(0));
        assertEquals("One", conversionService.getNumberinBritishEnglishWords(1));
    }
    @Test
    public void testConvertToBritishEnglishWordsBelow20() throws InvalidInputException
    {
        assertEquals("Nineteen", conversionService.getNumberinBritishEnglishWords(19));
    }

    @Test
    public void testConvertToBritishEnglishWordsBelow100() throws InvalidInputException
    {
        assertEquals("Twenty One", conversionService.getNumberinBritishEnglishWords(21));
        assertEquals("Ninety Two", conversionService.getNumberinBritishEnglishWords(92));
    }

    @Test
    public void testConvertToBritishEnglishWordsBelow1000() throws InvalidInputException
    {
        assertEquals("One Hundread and Five", conversionService.getNumberinBritishEnglishWords(105));
        assertEquals("One Hundread and Twenty Three", conversionService.getNumberinBritishEnglishWords(123));
        assertEquals("Six Hundread and Seventy Eight", conversionService.getNumberinBritishEnglishWords(678));
        assertEquals("Eight Hundread", conversionService.getNumberinBritishEnglishWords(800));
    }

    @Test
    public void testConvertToBritishEnglishWordsBelow10000() throws InvalidInputException
    {
        assertEquals("One Thousand and Five",conversionService.getNumberinBritishEnglishWords(1005));
        assertEquals("One Thousand and Forty Two",conversionService.getNumberinBritishEnglishWords(1042));
        assertEquals("One Thousand One Hundread and Five",conversionService.getNumberinBritishEnglishWords(1105));
        assertEquals("Six Thousand Six Hundread and Seventy Eight", conversionService.getNumberinBritishEnglishWords(6678));
    }
    @Test
    public void testConvertToBritishEnglishWordsBelow1000000() throws InvalidInputException
    {
        assertEquals("Nine Hundread and Forty Five Thousand", conversionService.getNumberinBritishEnglishWords(945000));
        assertEquals("Nine Hundread and Forty Five Thousand Seven Hundread and Eighty One", conversionService.getNumberinBritishEnglishWords(945781));
        assertEquals("Eight Hundread and Seventy Eight Thousand Seven Hundread and Eighty", conversionService.getNumberinBritishEnglishWords(878780));
    }


    @Test
    public void testConvertToBritishEnglishWordsBelow100000() throws InvalidInputException
    {
        assertEquals("Sixty Six Thousand Seven Hundread and Eighty", conversionService.getNumberinBritishEnglishWords(66780));
    }

    @Test
    public void testConvertToBritishEnglishWordsBelowMillion() throws InvalidInputException
    {
        assertEquals("Fifty Six Million and Eight", conversionService.getNumberinBritishEnglishWords(56000008));
        assertEquals("Fifty Six Million Nine Hundread and Forty Five Thousand Seven Hundread and Eighty One", conversionService.getNumberinBritishEnglishWords(56945781));
    }

    @Test
    public void testConvertToBritishEnglishWordsBelowMillions() throws InvalidInputException
    {
        assertEquals("Nine Hundread and Ninety Nine Million", conversionService.getNumberinBritishEnglishWords(999000000));
        assertEquals("Nine Hundread and Ninety Nine Million Nine Hundread and Ninety Nine Thousand Nine Hundread and Ninety Nine", conversionService.getNumberinBritishEnglishWords(999999999));
    }
}
