package com.merchants.guide.galaxy.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.merchants.guide.galaxy.Sentence;
import com.merchants.guide.galaxy.enums.ErrorsEnum;
import com.merchants.guide.galaxy.interfaces.NotesProcessor;
import com.merchants.guide.galaxy.util.RomanToDecimal;


/**
 * The Class IntergalaticNotesProcessor.<br>
 * This class is responsible for read and process all sentences.
 */
public class IntergalaticNotesProcessor implements NotesProcessor {

	/** All the sentences. */
	private List<Sentence> allSentences;
	
	/** The intergalatic roman map. It maps the word and the respective Roman letter.*/
	private Map<String, String> intergalaticRomanMap;
	
	/** The intergalatic unit credits map. It maps the unit and its value. */
	private Map<String, Double> intergalaticUnitCreditsMap;
	
	/**
	 * Instantiates a new IntergalaticNotesProcessor.
	 */
	public IntergalaticNotesProcessor(){
		this.allSentences = new ArrayList<Sentence>();
		this.intergalaticRomanMap = new HashMap<String, String>();
		this.intergalaticUnitCreditsMap = new HashMap<String, Double>();
	}

	/**
	 * Read all sentences.<br>
	 * Empty line means the end of the input data.
	 */
	public void readAllSentences() {
		Scanner in = new Scanner(System.in);    	
    	//read all input sentences from stdin
    	while(in.hasNextLine()){
    		String line = in.nextLine();
    		//empty line means the end of the input data
    		if(line.isEmpty()){
    			break;
    		}else{
    			this.allSentences.add(new Sentence(line));
    		}
    	}
    	in.close();
	}

	/**
	 * Process all sentences based on the sentence type.
	 */
	public void processAllSentences() {
		for (Sentence sentence : this.allSentences){
			switch (sentence.getType()){
				case DEFINING_ROMAN :
					updateIntergalaticRomanMap(sentence);
					break;
				case DEFINING_CREDITS :
					updateIntergalaticUnitCreditsMap(sentence);
					break;
				case QUERY_HOW_MUCH :
					handleHowMuchQuery(sentence);
					break;
				case QUERY_HOW_MANY :
					handleHowManyQuery(sentence);
					break;
				default :
					handleInvalidSentence();
					break;					
			}
		}
	}

	/**
	 * Handle how many query.
	 * Prints the answer for how many query.<br>
	 * In case of problem, calls  {@link #handleInvalidSentence()} method.
	 *
	 * @param sentence the sentence
	 */
	private void handleHowManyQuery(Sentence sentence) {
		double intergalaticCredits = 1;
		StringBuilder romanNumberBuilder = new StringBuilder();
		StringBuilder intergalaticAnswerHowManyBuilder = new StringBuilder();
		for(int i=4; i < sentence.getWordsArray().length-1; i++){
			String romanLetter = intergalaticRomanMap.get(sentence.getWordsArray()[i]);
			if (romanLetter != null){
				//found the word in the intergalatic Roman map
				romanNumberBuilder.append(romanLetter);
				intergalaticAnswerHowManyBuilder.append(sentence.getWordsArray()[i] + " ");
			}else if (intergalaticUnitCreditsMap.containsKey(sentence.getWordsArray()[i])){
				//found the word in the intergalatic unit credits map
				intergalaticCredits = intergalaticUnitCreditsMap.get(sentence.getWordsArray()[i]);
				intergalaticAnswerHowManyBuilder.append(sentence.getWordsArray()[i] + " ");				
			}else{
				//error - word not found
				handleInvalidSentence();
				return;
			}
		}
		int romanIntValue = RomanToDecimal.romanToDecimal(romanNumberBuilder.toString());
		Double creditsAnswer = new Double (romanIntValue * intergalaticCredits);
		intergalaticAnswerHowManyBuilder.append("is " + creditsAnswer.intValue() + " Credits");		
		System.out.println(intergalaticAnswerHowManyBuilder.toString());
	}

	/**
	 * Handle how much query.<br>
	 * Prints the answer for how much query.<br>
	 * In case of problem, calls  {@link #handleInvalidSentence()} method.
	 *
	 * @param sentence the sentence
	 */
	private void handleHowMuchQuery(Sentence sentence) {
		StringBuilder romanNumberBuilder = new StringBuilder();
		StringBuilder intergalaticAnswerHowMuchBuilder = new StringBuilder();
		for(int i=3; i < sentence.getWordsArray().length-1; i++){
			String romanLetter = intergalaticRomanMap.get(sentence.getWordsArray()[i]);
			if (romanLetter != null){
				//found the word in the intergalatic Roman map
				romanNumberBuilder.append(romanLetter);
				intergalaticAnswerHowMuchBuilder.append(sentence.getWordsArray()[i] + " ");
			}else{
				//error - word not found
				handleInvalidSentence();
				return;
			}
		}
		int romanIntValue = RomanToDecimal.romanToDecimal(romanNumberBuilder.toString());
		intergalaticAnswerHowMuchBuilder.append("is " + romanIntValue);
		System.out.println(intergalaticAnswerHowMuchBuilder.toString());
	}

	/**
	 * Update intergalatic unit credits map.<br>
	 * Maps the unit and its value.
	 *
	 * @param sentence the sentence
	 */
	private void updateIntergalaticUnitCreditsMap(Sentence sentence) {
		StringBuilder romanNumberBuilder = new StringBuilder();
		String interalaticUnit = "";
		int credits = -1;
		for(String word : sentence.getWordsArray()){
			if (!word.equals("is") && !word.equals("Credits")){
				String romanLetter = intergalaticRomanMap.get(word);
				if (romanLetter != null){
					romanNumberBuilder.append(romanLetter);
				} else if (interalaticUnit.isEmpty()){
					interalaticUnit = word;
				} else{
					credits = Integer.parseInt(word);
				}
			}
		}
		int romanIntValue = RomanToDecimal.romanToDecimal(romanNumberBuilder.toString());
		double valueOfIntergalaticUnit = (double) credits/romanIntValue;
		intergalaticUnitCreditsMap.put(interalaticUnit, valueOfIntergalaticUnit);
		
	}

	/**
	 * Update intergalatic roman map.<br>
	 * Maps the word and the Roman letter.
	 *
	 * @param sentence the sentence
	 */
	private void updateIntergalaticRomanMap(Sentence sentence) {
		intergalaticRomanMap.put(sentence.getWordsArray()[0], sentence.getWordsArray()[2]);
	}
	
	/**
	 * Handle invalid sentence.<br>
	 * Prints the error message.
	 */
	private void handleInvalidSentence() {
		System.out.println(ErrorsEnum.INVALID_SENTENCE);		
	}
	
	/**
	 * Gets the all sentences.
	 *
	 * @return the all sentences
	 */
	public List<Sentence> getAllSentences() {
		return allSentences;
	}
	
	/**
	 * Gets the intergalatic roman map.
	 *
	 * @return the intergalatic roman map
	 */
	public Map<String, String> getIntergalaticRomanMap() {
		return intergalaticRomanMap;
	}

	/**
	 * Gets the intergalatic unit credits map.
	 *
	 * @return the intergalatic unit credits map
	 */
	public Map<String, Double> getIntergalaticUnitCreditsMap() {
		return intergalaticUnitCreditsMap;
	}

}
