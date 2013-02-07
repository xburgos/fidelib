package org.runtimerror.fidelib;
/**
 * 
 * @author Xabier Burgos
 *
 */
public interface SectionDelimiter {
	/**
	 * 
	 * @param line
	 * @return
	 */
	Boolean isWithinLimits(String line);
	/**
	 * 
	 * @return
	 */
	Boolean isOver();
	
}
