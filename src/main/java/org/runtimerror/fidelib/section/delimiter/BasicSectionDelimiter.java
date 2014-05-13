/**
 * 
 */
package org.runtimerror.fidelib.section.delimiter;


/**
 * @author Ess Laptop
 *
 */
public class BasicSectionDelimiter extends AbstractSectionDelimiter {
	
	public BasicSectionDelimiter() {
		this.startString = "";
		this.endString = "";
	}
	
	public BasicSectionDelimiter(String startString, String endString) {
		this.startString = startString;
		this.endString = endString;
	}
	
}
