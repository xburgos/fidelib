/**
 * 
 */
package org.runtimerror.fidelib.impl;

import org.runtimerror.fidelib.FileDescription;



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
