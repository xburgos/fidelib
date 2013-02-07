package org.runtimerror.fidelib;

import org.runtimerror.fidelib.exception.ParserException;

public interface Parser {

	public abstract ParseReport parse(FileDescriptor descriptor, String filePath)
			throws ParserException;

	public abstract ParseReport parse(String path) throws ParserException;

	public abstract ParseReport parse() throws ParserException;

}