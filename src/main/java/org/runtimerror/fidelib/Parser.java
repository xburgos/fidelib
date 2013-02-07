package org.runtimerror.fidelib;

import org.runtimerror.fidelib.exception.ParserException;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public interface Parser {

	public abstract ParseReport parse(FileDescriptor descriptor, String filePath)
			throws ParseException;

	public abstract ParseReport parse(String path) throws ParseException;

	public abstract ParseReport parse() throws ParserException;

}