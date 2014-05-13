package org.runtimerror.fidelib.section.delimiter;
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
