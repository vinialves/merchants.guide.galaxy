package com.merchants.guide.galaxy.enums;

/**
 * The Enum RomanNumbersEnum.<br>
 * Contains all Roman symbols.
 */
public enum RomanNumbersEnum {
	
	/** The I. */
	I(1), 
	
	/** The V. */
	V(5),
	
	/** The X. */
	X(10),
	
	/** The L. */
	L(50),
	
	/** The C. */
	C(100),
	
	/** The D. */
	D(500),
	
	/** The M. */
	M(1000);
	
	/** The value. */
	private int value;
	
	/**
	 * Instantiates a new roman numbers enum.
	 *
	 * @param value the value
	 */
	RomanNumbersEnum(int value){
		this.value = value;
	}
	
	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public int getValue(){
		return this.value;
	}
	
	/**
	 * Gets the roman number from letter.
	 *
	 * @param letter the letter
	 * @return the roman number from letter
	 */
	public static RomanNumbersEnum getRomanNumberFromLetter(final char letter){
		for (RomanNumbersEnum romanNumbersEnum : RomanNumbersEnum.values()){
			if (romanNumbersEnum.name().charAt(0) == letter){
				return romanNumbersEnum;
			}
		}
		return null;
	}
	
}
