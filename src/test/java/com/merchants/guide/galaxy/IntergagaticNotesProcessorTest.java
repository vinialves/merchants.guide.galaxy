package com.merchants.guide.galaxy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.merchants.guide.galaxy.impl.IntergalaticNotesProcessor;

public class IntergagaticNotesProcessorTest {

	private IntergalaticNotesProcessor notes;

	private static final String[] INPUT_1 = { "glob is I", 
			"prok is V", 
			"pish is X", "tegj is L",
			"glob glob Silver is 34 Credits", 
			"glob prok Gold is 57800 Credits", 
			"pish pish Iron is 3910 Credits",
			"how much is pish tegj glob glob ?", 
			"how many Credits is glob prok Silver ?",
			"how many Credits is glob prok Gold ?", 
			"how many Credits is glob prok Iron ?",
			"how much wood could a woodchuck chuck if a woodchuck could chuck wood ?" };

	private static final String OUTPUT_1 = "pish tegj glob glob is 42\r\n"
			+ "glob prok Silver is 68 Credits\r\n"
			+ "glob prok Gold is 57800 Credits\r\n"
			+ "glob prok Iron is 782 Credits\r\n"
			+ "I have no idea what you are talking about\r\n";
	
	private static final String[] INPUT_2 = {  
			"Fus is X",
			"Roh is I",
			"Dah is V",
			"Fus Roh Dah DragonShout is 14 Credits",
			"how much is Fus Roh Dah ?",
			"how many Credits is Fus Roh Dah DragonShout ?",
			"Dragon Shouts are an ancient form of magic prominently used in Skyrim" };
	
	private static final String OUTPUT_2 = "Fus Roh Dah is 14\r\n"
			+ "Fus Roh Dah DragonShout is 14 Credits\r\n"
			+ "I have no idea what you are talking about\r\n";
	
	private static final String[] INPUT_3 = {  
			"Fus is X",
			"Roh is I",
			"Dah is V",
			"Fus Roh Dah DragonShout is 14 Credits",
			"how much is Fus Bah Qo ?",
			"how many Credits is Fus Roh Bah DragonShout ?" };
	
	private static final String OUTPUT_3 = "I have no idea what you are talking about\r\n"
			+ "I have no idea what you are talking about\r\n";

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	@Before
	public void setUp() {
		notes = new IntergalaticNotesProcessor();
		System.setOut(new PrintStream(outContent));
	}
		
	@Test
	public void processAllSentencesTest1(){
		initializeNotesFromInput(INPUT_1);
		
		notes.processAllSentences();

		assertEquals("I", notes.getIntergalaticRomanMap().get("glob"));
		assertEquals("V", notes.getIntergalaticRomanMap().get("prok"));
		assertEquals("X", notes.getIntergalaticRomanMap().get("pish"));
		assertEquals("L", notes.getIntergalaticRomanMap().get("tegj"));
		
		assertTrue(17.0 == notes.getIntergalaticUnitCreditsMap().get("Silver"));
		assertTrue(14450.0 == notes.getIntergalaticUnitCreditsMap().get("Gold"));
		assertTrue(195.5 == notes.getIntergalaticUnitCreditsMap().get("Iron"));

		assertEquals(OUTPUT_1, outContent.toString());
	}
	
	@Test
	public void processAllSentencesTest2(){
		initializeNotesFromInput(INPUT_2);		
		notes.processAllSentences();

		assertEquals("X", notes.getIntergalaticRomanMap().get("Fus"));
		assertEquals("I", notes.getIntergalaticRomanMap().get("Roh"));
		assertEquals("V", notes.getIntergalaticRomanMap().get("Dah"));
		
		assertTrue(1.0 == notes.getIntergalaticUnitCreditsMap().get("DragonShout"));

		assertEquals(OUTPUT_2, outContent.toString());
	}
	
	@Test
	public void processAllSentencesWordsInQueriesNotMappedTest(){
		initializeNotesFromInput(INPUT_3);		
		notes.processAllSentences();

		assertEquals("X", notes.getIntergalaticRomanMap().get("Fus"));
		assertEquals("I", notes.getIntergalaticRomanMap().get("Roh"));
		assertEquals("V", notes.getIntergalaticRomanMap().get("Dah"));
		
		assertTrue(1.0 == notes.getIntergalaticUnitCreditsMap().get("DragonShout"));

		assertEquals(OUTPUT_3, outContent.toString());
	}
	
	@After
	public void tearDown() {
		System.setOut(null);
	}
	
	private void initializeNotesFromInput(String[] inputArray){
		for (String line : inputArray){
			Sentence sentence = new Sentence(line);
			this.notes.getAllSentences().add(sentence);
		}
	}
}
