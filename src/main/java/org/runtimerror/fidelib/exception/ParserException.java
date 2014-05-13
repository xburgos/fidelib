/**
 * 
 */
package org.runtimerror.fidelib.exception;

/**
 * @author Ess Laptop
 *
 */
@SuppressWarnings("serial")
public class ParserException extends RuntimeException {

	/**
	 * 
	 */
	public ParserException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public ParserException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public ParserException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ParserException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

}
