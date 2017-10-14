package com.merchants.guide.galaxy.util;

import com.merchants.guide.galaxy.enums.RomanNumbersEnum;

/**
 * The Class RomanToDecimal.<br>
 * Helps in the conversion between Roman numbers and decimal.
 */
public final class RomanToDecimal {
    
	/**
	 * Roman to decimal.
	 *
	 * @param romanNumber the roman number
	 * @return the int
	 */
	public static int romanToDecimal(String romanNumber) {
        int decimal = 0;
        int lastNumber = 0;
        for (int i = romanNumber.length() - 1; i >= 0 ; i--) {
            RomanNumbersEnum romanNumberEnum = RomanNumbersEnum.
            		getRomanNumberFromLetter(romanNumber.charAt(i));
            if (romanNumberEnum != null){
	            decimal = getDecimal(romanNumberEnum.getValue(), lastNumber, decimal);            
	            lastNumber = romanNumberEnum.getValue();
            }
        }
        return decimal;
    }

    /**
     * Gets the decimal.
     *
     * @param decimal the decimal
     * @param lastNumber the last number
     * @param lastDecimal the last decimal
     * @return the decimal
     */
    private static int getDecimal(int decimal, int lastNumber, int lastDecimal) {
        if (lastNumber > decimal){
            return lastDecimal - decimal;
        } 
        
        return lastDecimal + decimal;
    }
}
