/**
 * 
 */
package org.runtimerror.fidelib;

import java.io.BufferedReader;
import java.util.List;

/**
 * @author Xabier Burgos
 *
 */
public interface FileSection {
	/**
	 * 
	 * @param reader
	 * @return
	 */
	Object parseSection(Integer lineNumber, ParseReport report, BufferedReader reader) throws Exception;
	
	Boolean isSectionWithinLimits(String line);
	
	Boolean isSectionOver();
	
	void setParsedLines(List<Object> dataMap);
	
	List<Object> getParsedLines();
}
