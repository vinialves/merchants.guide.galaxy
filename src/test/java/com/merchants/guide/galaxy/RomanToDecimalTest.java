package com.merchants.guide.galaxy;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.merchants.guide.galaxy.util.RomanToDecimal;

public class RomanToDecimalTest {
	
	@Test
	public void romanToDecimalTest(){
		assertTrue(1 == RomanToDecimal.romanToDecimal("I"));
		assertTrue(2 == RomanToDecimal.romanToDecimal("II"));
		assertTrue(3 == RomanToDecimal.romanToDecimal("III"));
		assertTrue(4 == RomanToDecimal.romanToDecimal("IV"));
		assertTrue(5 == RomanToDecimal.romanToDecimal("V"));
		assertTrue(6 == RomanToDecimal.romanToDecimal("VI"));
		assertTrue(7 == RomanToDecimal.romanToDecimal("VII"));
		assertTrue(8 == RomanToDecimal.romanToDecimal("VIII"));
		assertTrue(9 == RomanToDecimal.romanToDecimal("IX"));
		assertTrue(10 == RomanToDecimal.romanToDecimal("X"));
		assertTrue(20 == RomanToDecimal.romanToDecimal("XX"));
		assertTrue(1800 == RomanToDecimal.romanToDecimal("MDCCC"));
		assertTrue(71 == RomanToDecimal.romanToDecimal("LXXI"));
		assertTrue(52 == RomanToDecimal.romanToDecimal("LII"));
		assertTrue(900 == RomanToDecimal.romanToDecimal("CM"));
		assertTrue(88 == RomanToDecimal.romanToDecimal("LXXXVIII"));		
	}
}
