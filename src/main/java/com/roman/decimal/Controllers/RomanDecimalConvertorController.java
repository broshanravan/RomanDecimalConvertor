package com.roman.decimal.Controllers;
import com.roman.decimal.util.ConvertorUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RomanDecimalConvertorController {
    Logger logger = LogManager.getLogger(RomanDecimalConvertorController.class);

    @Autowired
    ConvertorUtil convertorUtil;
    /**
     * first Checks if the String input presents a valid integer
     * then the string will be sent to be converted to roman
     * by the dedicated function.
     * In case the input String is not valid
     * an appropriate error will be relayed back to the user
     * @param decimalNumberIn
     * @return
     */
    @GetMapping("/decimalToRoman")
    public String getRomanEquivalent(@RequestParam(name="decimalNumberIn", required = true, defaultValue = "2") String decimalNumberIn){

        try{
            if(decimalNumberIn.contains(".")){
                logger.error("Not an Integer");
                return "Not an Integer";
            }
            int inputNumber = Integer.parseInt(decimalNumberIn);
            return  convertorUtil.convertDecimalToRoman(inputNumber);

        }catch(NumberFormatException nfe){
            logger.error("Invalid Number");
            return "Invalid Number";
        }catch (NullPointerException npe){
            logger.error("Number not defined");
            return "Number not defined";
        }
    }



    /**
     *In case the roman number  entered id correct it will
     * be converted to decimal number
     * @param romanNumberIn
     * @return
     */
    @GetMapping("/romanToDecimal")
    public String romanToDecimal(@RequestParam(name="romanNumberIn", required = true, defaultValue = "I") String romanNumberIn) {

        if(convertorUtil.isAValidRomanNumber(romanNumberIn)){
            String decimalEquivalent =  String.valueOf(convertorUtil.getConvertedDecimalFromRoman(romanNumberIn));
            return decimalEquivalent;
        }
        return ("Invalid Roman Number");
    }

}
