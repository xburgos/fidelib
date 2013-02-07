package org.runtimerror.fidelib;

import java.util.List;


/**
 * 
 * @author Xabier Burgos.
 *
 */
public interface LineReader {
	/**
	 * 
	 */
	Object parseLine(Integer lineNumber,String line, ParseReport report)throws Exception;
	
	List<Object> getParsedLines();
	
	void setParsedLines(List<Object> parsedLines);
	
}
