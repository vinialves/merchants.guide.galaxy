package com.merchants.guide.galaxy;

import com.merchants.guide.galaxy.impl.IntergalaticNotesProcessor;
import com.merchants.guide.galaxy.interfaces.NotesProcessor;

/**
 * The facade Class NotesProcessorMaker.<br>
 * Useful if someday the application needs to handle other kind of notes.
 */
public class NotesProcessorMaker {

	/** The intergalatic notes processor. */
	private NotesProcessor intergalaticNotesProcessor;
	
	/**
	 * Instantiates a new notes processor maker.
	 */
	public NotesProcessorMaker(){
		intergalaticNotesProcessor = new IntergalaticNotesProcessor();
	}
	
	/**
	 * Handle intergalatic notes.
	 */
	public void handleIntergalaticNotes(){
		this.intergalaticNotesProcessor.readAllSentences();
		this.intergalaticNotesProcessor.processAllSentences();		
	}
}
