package com.merchants.guide.galaxy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.merchants.guide.galaxy.enums.SentenceTypeEnum;

public class SentenceTest {
	
	private Sentence sentence;
	private static final String DEFINING_ROMAN_SENTENCE = "glob is I";
	private static final String DEFINING_CREDITS_SENTENCE = "pish pish Iron is 3910 Credits";
	private static final String QUERY_HOW_MUCH_SENTENCE = "how much is pish tegj glob glob ?";
	private static final String QUERY_HOW_MANY_SENTENCE = "how many Credits is glob prok Iron ?";
	private static final String INVALID_SENTENCE = "how much wood could a woodchuck chuck if a woodchuck could chuck wood ?";
	
	@Test
	public void createTest(){
		sentence = new Sentence(INVALID_SENTENCE);
		assertEquals(INVALID_SENTENCE, sentence.getSentence());
		assertTrue(sentence.getWordsArray().length == 14);
	}
	
	@Test
	public void getTypeTest(){
		sentence = new Sentence(DEFINING_ROMAN_SENTENCE);
		assertTrue(SentenceTypeEnum.DEFINING_ROMAN == sentence.getType());
		sentence = new Sentence(DEFINING_CREDITS_SENTENCE);
		assertTrue(SentenceTypeEnum.DEFINING_CREDITS == sentence.getType());
		sentence = new Sentence(QUERY_HOW_MUCH_SENTENCE);
		assertTrue(SentenceTypeEnum.QUERY_HOW_MUCH == sentence.getType());
		sentence = new Sentence(QUERY_HOW_MANY_SENTENCE);
		assertTrue(SentenceTypeEnum.QUERY_HOW_MANY == sentence.getType());
		sentence = new Sentence(INVALID_SENTENCE);
		assertTrue(SentenceTypeEnum.INVALID == sentence.getType());		
		
	}	
	
}
