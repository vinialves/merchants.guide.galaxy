package com.merchants.guide.galaxy;

import com.merchants.guide.galaxy.impl.IntergalaticNotesProcessor;
import com.merchants.guide.galaxy.interfaces.NotesProcessor;

/**
 * A factory for creating NotesProcessor objects.
 */
public class NotesProcessorFactory {

	/**
	 * Gets the notes processor.
	 *
	 * @param notesProcessorType the notes processor type
	 * @return the notes processor
	 */
	public NotesProcessor getNotesProcessor(String notesProcessorType){
		if (notesProcessorType == null){
			return null;
		}
		if (notesProcessorType.equalsIgnoreCase("INTERGALATIC")){
			return new IntergalaticNotesProcessor();
		}
		
		return null;
	}
}
