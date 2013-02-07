/**
 * 
 */
package org.runtimerror.fidelib.impl;

import org.runtimerror.fidelib.FileDescriptor;



/**
 * @author Ess Laptop
 *
 */
public class BasicFileDescriptor extends FileDescriptor {
	
	public BasicFileDescriptor() {
		setLineSeparator(DEFAULT_LINE_SEPARATOR);
	}
	
	public BasicFileDescriptor(String lineSeparator) {
		setLineSeparator(lineSeparator);
	}

}
