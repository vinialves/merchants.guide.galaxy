package com.merchants.guide.galaxy;

import com.merchants.guide.galaxy.enums.RomanNumbersEnum;
import com.merchants.guide.galaxy.enums.SentenceTypeEnum;

/**
 * The Class Sentence.<br>
 * A sentence is a line in the notes.
 */
public class Sentence {
	
	/** The sentence. */
	private String sentence;
	
	/** The words array is the sentence splitted on whitespaces. */
	private String[] wordsArray;

	/**
	 * Instantiates a new sentence.
	 *
	 * @param line the line
	 */
	public Sentence(String line) {
		this.sentence = line.trim();
		this.wordsArray = line.trim().split("\\s+");
	}
	
	/**
	 * Gets the sentence.
	 *
	 * @return the sentence
	 */
	public String getSentence() {
		return sentence;
	}

	/**
	 * Sets the sentence.
	 *
	 * @param sentence the new sentence
	 */
	public void setSentence(String sentence) {
		this.sentence = sentence;
	}
		
	/**
	 * Gets the words array.
	 *
	 * @return the words array
	 */
	public String[] getWordsArray() {
		return wordsArray;
	}

	/**
	 * Sets the words array.
	 *
	 * @param wordsArray the new words array
	 */
	public void setWordsArray(String[] wordsArray) {
		this.wordsArray = wordsArray;
	}	

	/**
	 * Gets the type.
	 * @see com.merchants.guide.galaxy.enums.SentenceTypeEnum
	 * @return the type
	 */
	public SentenceTypeEnum getType() {
		
		if (this.wordsArray.length == 3 && 
				this.wordsArray[1].equals("is") && 
				RomanNumbersEnum.getRomanNumberFromLetter(this.wordsArray[2].charAt(0)) != null){
			return SentenceTypeEnum.DEFINING_ROMAN;
		}
		
		if (this.wordsArray.length > 4 &&
			this.wordsArray[this.wordsArray.length-1].equals("Credits") &&
			this.wordsArray[this.wordsArray.length-2].matches("\\d+") &&
			this.wordsArray[this.wordsArray.length-3].equals("is")){
			return SentenceTypeEnum.DEFINING_CREDITS;
		}
		
		if (this.wordsArray[this.wordsArray.length-1].equals("?")){
			if (this.wordsArray.length > 4 && 
				this.sentence.startsWith("how much is")){
				return SentenceTypeEnum.QUERY_HOW_MUCH;	
			}else if(this.wordsArray.length > 5 && 
					 this.sentence.startsWith("how many Credits is")){
				return SentenceTypeEnum.QUERY_HOW_MANY;
			}
		}
		
		return SentenceTypeEnum.INVALID;
	}
	
}
