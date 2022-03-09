package com.roman.decimal.util;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

@Component
public class ConvertorUtil {

    Logger logger = LogManager.getLogger(ConvertorUtil.class);

    private final static TreeMap<Integer, String> numberDecimalMap = new TreeMap<Integer, String>();

    static {

        numberDecimalMap.put(1000, "M");
        numberDecimalMap.put(900, "CM");
        numberDecimalMap.put(500, "D");
        numberDecimalMap.put(400, "CD");
        numberDecimalMap.put(100, "C");
        numberDecimalMap.put(90, "XC");
        numberDecimalMap.put(50, "L");
        numberDecimalMap.put(40, "XL");
        numberDecimalMap.put(10, "X");
        numberDecimalMap.put(9, "IX");
        numberDecimalMap.put(5, "V");
        numberDecimalMap.put(4, "IV");
        numberDecimalMap.put(1, "I");

    }

    /**
     * Given an integer it will return
     * using the threeMap numberDecimalMap
     * The roman counterpart
     * @param decimalNumber
     * @return
     */
    public String convertDecimalToRoman(int decimalNumber){

        int floorVal =  numberDecimalMap.floorKey(decimalNumber);
        if ( decimalNumber == floorVal ) {
            return numberDecimalMap.get(decimalNumber);
        }
        return numberDecimalMap.get(floorVal) + convertDecimalToRoman(decimalNumber - floorVal);

    }

    /**
     * Given a text it evaluates to
     * determine if it is a valid Roman
     * using a set of valid Romans
     * @param romanNumIn
     * @return
     */
    public boolean isAValidRomanNumber(String romanNumIn){
        Boolean isValid = true;
        List<String> validRomanCharacters = Arrays.asList("C", "D", "I", "L", "M", "V", "X");

        for(Character inputCharMember : romanNumIn.toCharArray()){
            isValid = validRomanCharacters.contains(inputCharMember.toString().toUpperCase());
            if(!isValid){
                logger.error("Invalid character ' " + inputCharMember + "'");
                break;
            }
        }
        return isValid;
    }

    /**
     * detting decimal equivalant
     * from each roman Number Character
     * @param decimal
     * @param lastNumber
     * @param lastDecimal
     * @return
     */
    public int processDecimal(int decimal, int lastNumber, int lastDecimal) {
        if (lastNumber > decimal) {
            return lastDecimal - decimal;
        } else {
            return lastDecimal + decimal;
        }
    }

    /**
     * given a Roman number
     * returns its decimal equivalent
     * @param romanNumberIn
     * @return
     */
    public String getConvertedDecimalFromRoman(String romanNumberIn){
        int decimal = 0;
        int lastNumber = 0;
        String romanNumeral = romanNumberIn.toUpperCase();
        for (int x = romanNumeral.length() - 1; x >= 0 ; x--) {
            char convertToDecimal = romanNumeral.charAt(x);

            switch (convertToDecimal) {
                case 'M':
                    decimal = processDecimal(1000, lastNumber, decimal);
                    lastNumber = 1000;
                    break;

                case 'D':
                    decimal = processDecimal(500, lastNumber, decimal);
                    lastNumber = 500;
                    break;

                case 'C':
                    decimal = processDecimal(100, lastNumber, decimal);
                    lastNumber = 100;
                    break;

                case 'L':
                    decimal = processDecimal(50, lastNumber, decimal);
                    lastNumber = 50;
                    break;

                case 'X':
                    decimal = processDecimal(10, lastNumber, decimal);
                    lastNumber = 10;
                    break;

                case 'V':
                    decimal = processDecimal(5, lastNumber, decimal);
                    lastNumber = 5;
                    break;

                case 'I':
                    decimal = processDecimal(1, lastNumber, decimal);
                    lastNumber = 1;
                    break;
            }
        }
        return String.valueOf(decimal);
    }
}

