/**
 * 
 */
package org.runtimerror.fidelib;

/**
 * @author Ess Laptop
 *
 */
public interface ParserEventSource {
	/**
	 * 
	 * @param listener
	 */
	void addListener(ParserEventListener listener);
	/**
	 * 
	 * @param listener
	 */
	void removeListener(ParserEventListener listener);
	/**
	 * 
	 */
	void notifyListeners();
}
