package com.roman.decimal.util;

import com.roman.decimal.Controllers.RomanDecimalConvertorController;
import org.junit.Test;

public class RomanDecimalConvertorTest {


    RomanDecimalConvertorController romanDecimalConvertorController = new RomanDecimalConvertorController();

    @Test
    public void testGetRomanEquivalentInvalidNumber(){
        String romanEquivalent = romanDecimalConvertorController.getRomanEquivalent("Twelve");
        assert("Invalid Number".equals(romanEquivalent));
    }

    @Test
    public void testGetRomanEquivalentInvalidInteger(){
        String romanEquivalent = romanDecimalConvertorController.getRomanEquivalent("1212.1");
        assert("Not an Integer".equals(romanEquivalent));
    }

    @Test
    public void testGetRomanEquivalentNullInput(){
        String romanEquivalent = romanDecimalConvertorController.getRomanEquivalent(null);
        assert("Number not defined".equals(romanEquivalent));
    }



}
