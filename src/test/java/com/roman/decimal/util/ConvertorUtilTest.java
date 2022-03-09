package com.roman.decimal.util;
import org.junit.Test;

public class ConvertorUtilTest {

    ConvertorUtil convertorUtil = new ConvertorUtil();
    @Test
    public void testConvertDecimalToRoman(){
        String romanEquivalent = convertorUtil.convertDecimalToRoman(12);
        assert("XII".equals(romanEquivalent));
    }

    @Test
    public void romanToDecimalTest(){
        String decimalEquivalent = convertorUtil.getConvertedDecimalFromRoman("XVI");
        assert("16".equals(decimalEquivalent));

    }

}
