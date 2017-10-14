package com.merchants.guide.galaxy.enums;

/**
 * The Enum ErrorsEnum.<br>
 * Contains all possible errors.
 */
public enum ErrorsEnum {
	
	INVALID_SENTENCE(0, "I have no idea what you are talking about");

	/** The error code. */
	private final int code;
	
	/** The error description. */
	private final String description;

	/**
	 * Instantiates a new errors enum.
	 *
	 * @param code the code
	 * @param description the description
	 */
	private ErrorsEnum(int code, String description) {
		this.code = code;
		this.description = description;
	}

	/**
	 * Gets the error description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Gets the error code.
	 *
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		return description;
	}
}