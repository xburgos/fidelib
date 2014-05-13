/**
 * 
 */
package org.runtimerror.fidelib.event;

import java.util.Map;

/**
 * @author Xabier
 *
 */
public interface ParseEvent {
	
	Integer getCurrentLineNumber();
	
	String getCurrentLine();
	
	String[] getCurrentParsedLine();
	
	Object getCurrentMappedLine();
	
	Map<Integer, String> getLinesReadSoFar();
	
	Map<Integer, String[]> getLinesParsedSoFar();
	
	Map<Integer, Object[]> getLinesMappedSoFar();
}
