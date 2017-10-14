package com.merchants.guide.galaxy;

import com.merchants.guide.galaxy.interfaces.NotesProcessor;

/**
 * <p>
 * The Class MerchantsGuideGalaxy.<br>
 * This is the Merchant's Guide to the Galaxy challenge.<br>
 * Assumptions: <br>
 * - The input data ends when an empty line is informed.<br>
 * - The system is case sensitive.<br>
 * - Reserved words and the pattern of the queries informed in the input data example must be respected.<br>
 * </p>
 * 
 * @author alvesvin
 */
public class MerchantsGuideGalaxy 
{
	
	/**
	 * The main method.<br>
	 * Reads a and process the notes.
	 *
	 * @param args the arguments
	 */
    public static void main(String[] args){    	
    	//NotesProcessorMaker notesProcessorMaker = new NotesProcessorMaker();
    	//notesProcessorMaker.handleIntergalaticNotes();
    	NotesProcessorFactory notesProcessorFactory = new NotesProcessorFactory();
    	NotesProcessor intergalaticNotesProcessor =  notesProcessorFactory.getNotesProcessor("INTERGALATIC");
    	intergalaticNotesProcessor.readAllSentences();
		intergalaticNotesProcessor.processAllSentences();	
    }
    
}
