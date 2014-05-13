/**
 * 
 */
package org.runtimerror.fidelib.description;


/**
 * @author Ess Laptop
 *
 */
public class BasicFileDescriptor extends FileDescription {
	
	public BasicFileDescriptor() {
		setLineSeparator(DEFAULT_LINE_SEPARATOR);
	}
	
	public BasicFileDescriptor(String lineSeparator) {
		setLineSeparator(lineSeparator);
	}

}
